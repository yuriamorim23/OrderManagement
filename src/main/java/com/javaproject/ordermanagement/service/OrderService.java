package com.javaproject.ordermanagement.service;

import java.util.List;

import com.javaproject.ordermanagement.dto.CreateOrderCommand;
import com.javaproject.ordermanagement.dto.GetOrderQueryResult;
import com.javaproject.ordermanagement.dto.UpdateOrderCommand;

public interface OrderService {
	
	List<GetOrderQueryResult> findAll();
	
	GetOrderQueryResult findById(Long id);

	GetOrderQueryResult createOrder(CreateOrderCommand createOrderCommand);

	GetOrderQueryResult updateOrder(UpdateOrderCommand updateOrderCommand, Long Id);

	void deleteById(Long id);
	
	GetOrderQueryResult changeOrderStatus(UpdateOrderCommand updateOrderCommand, Long id);

}
