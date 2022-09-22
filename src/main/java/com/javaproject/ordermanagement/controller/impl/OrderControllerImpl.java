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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.ordermanagement.controller.OrderController;
import com.javaproject.ordermanagement.dto.CreateOrderCommand;
import com.javaproject.ordermanagement.dto.GetOrderQueryResult;
import com.javaproject.ordermanagement.dto.UpdateOrderCommand;
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
	public ResponseEntity<GetOrderQueryResult> orderCreate(@RequestBody @Valid CreateOrderCommand createOrderCommand) {
		return new ResponseEntity<>(service.createOrder(createOrderCommand), HttpStatus.CREATED);
	}

	public ResponseEntity<GetOrderQueryResult> findById(Long id) {
		return null;
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		service.deleteById(id);
	}
	
	@PutMapping("/close/{id}")
	public ResponseEntity<GetOrderQueryResult> orderUpdateStatusClosed(@RequestBody @Valid UpdateOrderCommand updateOrderCommand, @PathVariable("id") Long id) {
		return new ResponseEntity<>(service.changeOrderStatusClosed(updateOrderCommand, id), HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/sold/{id}")
	public ResponseEntity<GetOrderQueryResult> orderUpdateStatusSold(@RequestBody @Valid UpdateOrderCommand updateOrderCommand, @PathVariable("id") Long id) {
		return new ResponseEntity<>(service.changeOrderStatusSold(updateOrderCommand, id), HttpStatus.NO_CONTENT);
	}

}
