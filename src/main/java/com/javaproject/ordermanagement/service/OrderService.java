package com.javaproject.ordermanagement.service;

import java.util.List;

import com.javaproject.ordermanagement.dto.GetOrderQueryResult;
import com.javaproject.ordermanagement.dto.CreateOrderCommand;
import com.javaproject.ordermanagement.dto.UpdateOrderCommand;

public interface OrderService {
	
	List<GetOrderQueryResult> findAll();
	
	GetOrderQueryResult findById(Long id);

	GetOrderQueryResult createOrderCommand(CreateOrderCommand submit);

	GetOrderQueryResult updateOrderCommand(UpdateOrderCommand update, Long Id);

	void deleteById(Long id);

}
