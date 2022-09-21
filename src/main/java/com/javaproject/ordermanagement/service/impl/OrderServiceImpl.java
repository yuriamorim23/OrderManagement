package com.javaproject.ordermanagement.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproject.ordermanagement.dto.CreateOrderCommand;
import com.javaproject.ordermanagement.dto.CreateOrderItemCommand;
import com.javaproject.ordermanagement.dto.GetOrderQueryResult;
import com.javaproject.ordermanagement.dto.UpdateOrderCommand;
import com.javaproject.ordermanagement.entities.Order;
import com.javaproject.ordermanagement.entities.OrderItem;
import com.javaproject.ordermanagement.enums.OrderStatus;
import com.javaproject.ordermanagement.exception.ProductNotFound;
import com.javaproject.ordermanagement.repositories.ClientRepository;
import com.javaproject.ordermanagement.repositories.OrderItemRepository;
import com.javaproject.ordermanagement.repositories.OrderRepository;
import com.javaproject.ordermanagement.repositories.ProductRepository;
import com.javaproject.ordermanagement.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

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
	public GetOrderQueryResult createOrder(CreateOrderCommand createOrderCommand) {
		Order order = convertToBusiness(createOrderCommand);
		orderRepository.save(order);
		List<OrderItem> orderItemsList = new ArrayList<OrderItem>();
		for (CreateOrderItemCommand orderItemCommand : createOrderCommand.getOrderItems()) {
			var product = productRepository.findById(orderItemCommand.getProductId()).get();
			var orderItem = new OrderItem(order, product, orderItemCommand.getPrice(), orderItemCommand.getQuantity());
			orderItemsList.add(orderItem);
		}
		orderItemRepository.saveAll(orderItemsList);
		return convertToDto(order);
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

	@Override
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
	public GetOrderQueryResult changeOrderStatus(UpdateOrderCommand updateOrderCommand, Long id) {
		Optional<Order> order = orderRepository.findById(id);
		if(order.isPresent()) {
			Order od = order.get();
			if(updateOrderCommand.getStatus() != null) {
				od.setStatus(OrderStatus.CLOSED);
			}
			orderRepository.save(od);
		}
		return null;
		
	}
}