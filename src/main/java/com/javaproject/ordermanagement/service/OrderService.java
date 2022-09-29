package com.javaproject.ordermanagement.service;

import java.util.List;

import com.javaproject.ordermanagement.dto.BaseApiResult;
import com.javaproject.ordermanagement.dto.CreateOrderCommand;
import com.javaproject.ordermanagement.dto.GetOrderQueryResult;
import com.javaproject.ordermanagement.dto.UpdateOrderCommand;

public interface OrderService {
	
	List<GetOrderQueryResult> findAll();
	
	GetOrderQueryResult findById(Long id);

	BaseApiResult createOrder(CreateOrderCommand createOrderCommand);

	GetOrderQueryResult updateOrder(UpdateOrderCommand updateOrderCommand, Long Id);

	void deleteById(Long id);
	
	BaseApiResult changeOrderStatusClosed(Long id);
	
	BaseApiResult changeOrderStatusSold(Long id);
	
}
