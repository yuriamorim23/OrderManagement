package com.javaproject.ordermanagement.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproject.ordermanagement.dto.BaseApiResult;
import com.javaproject.ordermanagement.dto.CreateOrderCommand;
import com.javaproject.ordermanagement.dto.CreateOrderItemCommand;
import com.javaproject.ordermanagement.dto.CreateOrderPaymentsCommand;
import com.javaproject.ordermanagement.dto.CreateOrderPaymentsListCommand;
import com.javaproject.ordermanagement.dto.GetOrderQueryResult;
import com.javaproject.ordermanagement.dto.UpdateOrderCommand;
import com.javaproject.ordermanagement.entities.Order;
import com.javaproject.ordermanagement.entities.OrderItem;
import com.javaproject.ordermanagement.entities.OrderPayments;
import com.javaproject.ordermanagement.enums.OrderStatus;
import com.javaproject.ordermanagement.exception.ProductNotFound;
import com.javaproject.ordermanagement.repositories.ClientRepository;
import com.javaproject.ordermanagement.repositories.OrderItemRepository;
import com.javaproject.ordermanagement.repositories.OrderPaymentsRepository;
import com.javaproject.ordermanagement.repositories.OrderRepository;
import com.javaproject.ordermanagement.repositories.PaymentMethodRepository;
import com.javaproject.ordermanagement.repositories.ProductRepository;
import com.javaproject.ordermanagement.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	BaseApiResult result;
	
	@Autowired
	private PaymentMethodRepository paymentMethodRepository;
	
	@Autowired
	private OrderPaymentsRepository orderPaymentsRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	public List<GetOrderQueryResult> findAll() {
		List<Order> dataBaseOrder = orderRepository.findAll();
		List<GetOrderQueryResult> orderList = new ArrayList<GetOrderQueryResult>();

		dataBaseOrder.forEach(item -> {
			orderList.add(new GetOrderQueryResult(item.getClient().getId(), item.getId(), item.getClientName(),
					item.getMoreInfo(), item.getStatus(), item.getTotal()));
		});
		return orderList;
	}

	@Transactional
	public GetOrderQueryResult findById(Long id) {
		Optional<Order> optional = orderRepository.findById(id);
		if (optional.isPresent()) {
			return convertToDto(optional.get());
		}
		throw new ProductNotFound();
	}

	@Transactional
	public BaseApiResult createOrder(CreateOrderCommand createOrderCommand) {
		Order order = convertToBusiness(createOrderCommand);
		orderRepository.save(order);
		List<OrderItem> orderItemsList = new ArrayList<OrderItem>();
		for (CreateOrderItemCommand orderItemCommand : createOrderCommand.getOrderItems()) {
			var product = productRepository.findById(orderItemCommand.getProductId()).get();
			var orderItem = new OrderItem(order, product, orderItemCommand.getPrice(), orderItemCommand.getQuantity());
			orderItemsList.add(orderItem);
		}
		orderItemRepository.saveAll(orderItemsList);
		var result = new BaseApiResult(true, "Order " + order.getId() + " created with success!");
		return result;
	}

	public Order convertToBusiness(CreateOrderCommand createOrderCommand) {
		Order order = new Order();
		order.setClient(clientRepository.findById(createOrderCommand.getClientId()).get());
		order.setMoreInfo(createOrderCommand.getMoreInfo());
		order.setStatus(OrderStatus.OPEN);
		order.setCloseSoldDate(new Date());
		order.setClientName(String.valueOf(order.getClient().getFirstName()));
		order.setTotal(createOrderCommand.getTotal());
		return order;
	}

	public GetOrderQueryResult convertToDto(Order order) {
		GetOrderQueryResult dto = new GetOrderQueryResult();
		dto.setClientId(order.getClient().getId());
		dto.setOrderId(order.getId());
		dto.setMoreInfo(order.getMoreInfo());
		dto.setStatus(order.getStatus());
		dto.setClientName(order.getClient().getFirstName());
		dto.setTotal(order.getTotal());
		return dto;
	}

	public GetOrderQueryResult updateOrder(UpdateOrderCommand updateOrderCommand, Long Id) {
		return null;
	}
	

	@Transactional
	public void deleteById(Long id) {
		if (orderRepository.existsById(id)) {
			orderRepository.deleteById(id);
		} else {
			throw new ProductNotFound();
		}
	}

	@Transactional
	public BaseApiResult changeOrderStatusClosed(Long id) {
		var order = orderRepository.findById(id).orElse(null);
		if(order == null)
		{
			return new BaseApiResult(false, "Order Id " + id + " does not exists.");
		}
		order.setStatus(OrderStatus.CLOSED);
		orderRepository.save(order);
		var result = new BaseApiResult(true, "Order closed with success!");
		return result;
	}
	
	@Transactional
	public BaseApiResult changeOrderStatusSold(Long id) {
		// passo 1 carregar a order
		result = new BaseApiResult(true, "");
		var order = orderRepository.findById(id).orElse(null);
		if(order == null)
		{
			return new BaseApiResult(false, "Order Id " + id + " does not exists.");
		}
		
		// passo 2 validar se o OrderItem é menor ou igual a quantidade de produto.
		var orderItems = orderItemRepository.findByOrder(order);
		orderItems.forEach(item ->{
			if(item.getQuantity() > item.getProduct().getStockQuantity()) {
				result = new BaseApiResult(false, "OrderItem " + item.getProduct().getDescription() + " not available (trying to sell " + item.getQuantity() + " - current quantity = " + item.getProduct().getStockQuantity() + "). ");
			}
		});
		// passo 3 Dar baixa no valor do stockQuantity, se passo 2 for false, retornar msg de erro.
		if(!result.isSuccess()) {
			return result;
		}
		
		orderItems.forEach(item -> {
			var quantity = item.getQuantity();
			var stock = item.getProduct().getStockQuantity();
			var newStock = stock - quantity;
			var product = item.getProduct();
			product.setStockQuantity(newStock);
			productRepository.save(product);
		});
		// passo 4 Mudar o OrderStatus para SOLD
		order.setStatus(OrderStatus.SOLD);
		orderRepository.save(order);
		
		result = new BaseApiResult(true, "Order sold with success!");
		return result;
	}

	@Transactional
	public BaseApiResult orderPayments(CreateOrderPaymentsCommand createOrderPaymentsCommand) {
		var order = orderRepository.findById(createOrderPaymentsCommand.getOrderId()).orElse(null);
		if(order == null)
		{
			return new BaseApiResult(false, "Order Id " + createOrderPaymentsCommand.getOrderId() + " does not exists.");
		}
		
		
		var result = new BaseApiResult(true, "Order payed with success!");
		return result;
	}
	
	/*public OrderPayments savePayments(CreateOrderPaymentsCommand createOrderPaymentsCommand) {
		OrderPayments orderPayments = new OrderPayments();
		orderPayments.setOrder(orderRepository.findById(createOrderPaymentsCommand.getOrderId()).get());
		return orderPayments;
		
	}*/
	
}