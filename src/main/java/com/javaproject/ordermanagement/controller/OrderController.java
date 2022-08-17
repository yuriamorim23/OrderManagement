package com.javaproject.ordermanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.javaproject.ordermanagement.dto.GetOrderQueryResult;
import com.javaproject.ordermanagement.dto.CreateOrderCommand;
import com.javaproject.ordermanagement.dto.UpdateProductCommand;
import com.javaproject.ordermanagement.entities.Order;

public interface OrderController {

	ResponseEntity<List<GetOrderQueryResult>> findAll();

	ResponseEntity<GetOrderQueryResult> findById(@PathVariable("id") Long id);
	
	ResponseEntity<GetOrderQueryResult> orderRegister(@RequestBody @Valid CreateOrderCommand createOrderCommand);
	
	Order updateById(@RequestBody UpdateProductCommand updateProductCommand, @PathVariable("id") Long id);
	
	void deleteById(@PathVariable("id") Long id);
	
}
