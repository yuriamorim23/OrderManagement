package com.javaproject.ordermanagement.controller.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.ordermanagement.controller.PaymentMethodController;
import com.javaproject.ordermanagement.dto.BaseApiResult;
import com.javaproject.ordermanagement.dto.CreatePaymentMethodCommand;
import com.javaproject.ordermanagement.service.PaymentMethodService;

@RestController
@RequestMapping(value = "api/v1/method")
public class PaymentMethodControllerImpl implements PaymentMethodController {

	@Autowired
	private PaymentMethodService service;
	
	@PostMapping
	public ResponseEntity<BaseApiResult> orderPayment(@Valid CreatePaymentMethodCommand createPaymentMethodCommand) {
		return new ResponseEntity<>(service.paymentMethod(createPaymentMethodCommand), HttpStatus.CREATED);
	}

}
