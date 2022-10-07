package com.javaproject.ordermanagement.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.ordermanagement.controller.OrderController;
import com.javaproject.ordermanagement.dto.BaseApiResult;
import com.javaproject.ordermanagement.dto.CreateOrderCommand;
import com.javaproject.ordermanagement.dto.CreateOrderPaymentsCommand;
import com.javaproject.ordermanagement.dto.GetOrderQueryResult;
import com.javaproject.ordermanagement.service.OrderService;

@RestController
@RequestMapping(value = "api/v1/order")
public class OrderControllerImpl implements OrderController {

	@Autowired
	private OrderService service;

	@GetMapping
	public ResponseEntity<List<GetOrderQueryResult>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<BaseApiResult> orderCreate(@RequestBody @Valid CreateOrderCommand createOrderCommand) {
		return new ResponseEntity<>(service.createOrder(createOrderCommand), HttpStatus.CREATED);
	}

	public ResponseEntity<GetOrderQueryResult> findById(Long id) {
		return null;
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		service.deleteById(id);
	}

	@PostMapping("/close/{id}")
	public ResponseEntity<BaseApiResult> orderUpdateStatusClosed(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.changeOrderStatusClosed(id), HttpStatus.OK);
	}

	@PostMapping("/sold/{id}")
	public ResponseEntity<BaseApiResult> orderUpdateStatusSold(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.changeOrderStatusSold(id), HttpStatus.OK);
	}

	@PostMapping("/payment")
	public ResponseEntity<BaseApiResult> orderPayments(@Valid CreateOrderPaymentsCommand createOrderPaymentsCommand) {
		return new ResponseEntity<>(service.orderPayments(createOrderPaymentsCommand), HttpStatus.OK);
	}

}
