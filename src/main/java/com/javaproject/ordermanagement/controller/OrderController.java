package com.javaproject.ordermanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.javaproject.ordermanagement.dto.BaseApiResult;
import com.javaproject.ordermanagement.dto.CreateOrderCommand;
import com.javaproject.ordermanagement.dto.CreateOrderPaymentsCommand;
import com.javaproject.ordermanagement.dto.GetOrderQueryResult;

public interface OrderController {

	ResponseEntity<List<GetOrderQueryResult>> findAll();

	ResponseEntity<GetOrderQueryResult> findById(@PathVariable("id") Long id);
	
	ResponseEntity<BaseApiResult> orderCreate(@RequestBody @Valid CreateOrderCommand createOrderCommand);
	
	ResponseEntity<BaseApiResult> orderPayments(@RequestBody @Valid CreateOrderPaymentsCommand createOrderPaymentsCommand);
	
	ResponseEntity<BaseApiResult> orderUpdateStatusClosed(@PathVariable("id") Long id);
	
	ResponseEntity<BaseApiResult> orderUpdateStatusSold(@PathVariable("id") Long id);
	
	void deleteById(@PathVariable("id") Long id);
	
}
