package com.javaproject.ordermanagement.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproject.ordermanagement.dto.CreateOrderCommand;
import com.javaproject.ordermanagement.dto.GetOrderQueryResult;
import com.javaproject.ordermanagement.dto.UpdateOrderCommand;
import com.javaproject.ordermanagement.entities.Order;
import com.javaproject.ordermanagement.entities.OrderItem;
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
	private ClientRepository clientRepository;

	@Autowired
	private ProductRepository productRepository;

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
		order = orderRepository.save(order);
		return convertToDto(order);
	}

	public Order convertToBusiness(CreateOrderCommand createOrderCommand) {
		Order order = new Order();
		order.setClient(clientRepository.findById(createOrderCommand.getClient()).get());
		order.setMoreInfo(createOrderCommand.getMoreInfo());
		order.setStatus(createOrderCommand.getStatus());
		order.setCloseSoldDate(new Date());
		for (OrderItem orderItem : order.getOrderItems()) {
			orderItem.setProduct(productRepository.findById(orderItem.getProduct()).get());
			orderItem.setOrder(orderRepository.findById(orderItem.getOrder()).get());
			orderItem.setPrice(orderItem.getPrice());
			orderItem.setQuantity(orderItem.getQuantity());
			orderItemRepository.saveAll(order.getOrderItems());
		}
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

/*
 * @Transactional public ProductDTO updateOrderCommand(ProductUpdate update,
 * Long Id) { Optional<Product> op = repository.findById(Id); if(op.isPresent())
 * { Product obj = op.get(); if(update.getDescription() != null &&
 * update.getMinPrince() != null && update.getPrice() != null &&
 * update.getStockQuantity() != null) { if(update.getMinPrince() >
 * update.getPrice()) { throw new MinPriceValidation(); }
 * obj.setDescription(update.getDescription());
 * obj.setMinPrince(update.getMinPrince()); obj.setPrice(update.getPrice());
 * obj.setStockQuantity(update.getStockQuantity()); } repository.save(obj);
 * return convertToDto(obj); } return null; }
 */