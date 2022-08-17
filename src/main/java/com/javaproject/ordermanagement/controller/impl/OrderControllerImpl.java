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
import com.javaproject.ordermanagement.dto.GetOrderQueryResult;
import com.javaproject.ordermanagement.dto.CreateOrderCommand;
import com.javaproject.ordermanagement.dto.UpdateProductCommand;
import com.javaproject.ordermanagement.entities.Order;
import com.javaproject.ordermanagement.service.OrderService;

@RestController
@RequestMapping(value = "api/v1/")
public class OrderControllerImpl implements OrderController {

	@Autowired
	private OrderService service;

	@GetMapping("/order")
	public ResponseEntity<List<GetOrderQueryResult>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@PostMapping("/order")
	public ResponseEntity<GetOrderQueryResult> orderRegister(@RequestBody @Valid CreateOrderCommand createOrderCommand) {
		return new ResponseEntity<>(service.createOrderCommand(createOrderCommand), HttpStatus.CREATED);
	}
	
	public ResponseEntity<GetOrderQueryResult> findById(Long id) {

		return null;
	}

	public Order updateById(UpdateProductCommand update, Long id) {

		return null;
	}

	@DeleteMapping("order/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		service.deleteById(id);
	}

}