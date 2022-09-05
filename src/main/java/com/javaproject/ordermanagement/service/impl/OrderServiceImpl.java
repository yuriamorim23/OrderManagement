package com.javaproject.ordermanagement.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproject.ordermanagement.dto.CreateOrderCommand;
import com.javaproject.ordermanagement.dto.CreateOrderItemCommand;
import com.javaproject.ordermanagement.dto.GetOrderQueryResult;
import com.javaproject.ordermanagement.dto.UpdateOrderCommand;
import com.javaproject.ordermanagement.entities.Order;
import com.javaproject.ordermanagement.entities.OrderItem;
import com.javaproject.ordermanagement.entities.Product;
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
		List<Order> all = orderRepository.findAll();
		return convertListToDto(all);
	}

	private static List<GetOrderQueryResult> convertListToDto(List<Order> order) {
		return order.stream().map(GetOrderQueryResult::new).collect(Collectors.toList());
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
		var savedOrder = orderRepository.save(order);
		
		List<OrderItem> orderItemsDomain = new ArrayList<OrderItem>();
		var orderItems = createOrderCommand.getOrderItems();
		//orderItems.forEach(item -> {
		createOrderCommand.getOrderItems().forEach(item -> {
			Product product = productRepository.findById(item.getProductId()).get();
			var orderItem = new OrderItem(order, product, item.getQuantity(), item.getPrice());
			orderItemsDomain.add(orderItem);
			//orderItemsDomain.add(new OrderItem(order, product, item.getQuantity(), item.getPrice()));
		});
		//orderItemsDomain.remove(0);
		orderItemRepository.saveAll(orderItemsDomain);
		
		//var primeiroProduto = orderItems.get(0);
				
		return convertToDto(order);
	}

	public Order convertToBusiness(CreateOrderCommand createOrderCommand) {
		var order = new Order();
		var client = clientRepository.findById(createOrderCommand.getClientId()).get();
		order.setClient(client);
		order.setMoreInfo(createOrderCommand.getMoreInfo());
		order.setStatus(OrderStatus.OPEN);
		order.setCloseSoldDate(new Date());
		
		/*for (OrderItem orderItem : createOrderCommand.getOrderItems()) {
			orderItem.setProduct(productRepository.findById(orderItem.getProduct().getId()).get());
			orderItem.setOrder(order);
			orderItem.setPrice(orderItem.getPrice());
			orderItem.setQuantity(orderItem.getQuantity());
		}*/
		return order;
	}

	@Transactional
	public void deleteById(Long id) {
		if (orderRepository.existsById(id)) {
			orderRepository.deleteById(id);
		} else {
			throw new ProductNotFound();
		}
	}

	public GetOrderQueryResult convertToDto(Order order) {
		GetOrderQueryResult dto = new GetOrderQueryResult();
		dto.setClient(order.getClient());
		dto.setMoreInfo(order.getMoreInfo());
		dto.setStatus(order.getStatus());
		dto.setCloseSoldDate(new Date());
		return dto;
	}

	@Override
	public GetOrderQueryResult updateOrder(UpdateOrderCommand updateOrderCommand, Long Id) {
		return null;
	}
}