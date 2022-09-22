package com.javaproject.ordermanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.javaproject.ordermanagement.dto.CreateOrderCommand;
import com.javaproject.ordermanagement.dto.GetOrderQueryResult;
import com.javaproject.ordermanagement.dto.UpdateOrderCommand;

public interface OrderController {

	ResponseEntity<List<GetOrderQueryResult>> findAll();

	ResponseEntity<GetOrderQueryResult> findById(@PathVariable("id") Long id);
	
	ResponseEntity<GetOrderQueryResult> orderCreate(@RequestBody @Valid CreateOrderCommand createOrderCommand);
	
	ResponseEntity<GetOrderQueryResult> orderUpdateStatusClosed(@RequestBody UpdateOrderCommand updateOrderCommand, @PathVariable("id") Long id);
	
	ResponseEntity<GetOrderQueryResult> orderUpdateStatusSold(@RequestBody UpdateOrderCommand updateOrderCommand, @PathVariable("id") Long id);
	
	void deleteById(@PathVariable("id") Long id);
	
}
