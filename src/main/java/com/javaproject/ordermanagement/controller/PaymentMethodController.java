package com.javaproject.ordermanagement.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.javaproject.ordermanagement.dto.BaseApiResult;
import com.javaproject.ordermanagement.dto.CreatePaymentMethodCommand;

public interface PaymentMethodController {

	ResponseEntity<BaseApiResult> orderPayment(@RequestBody @Valid CreatePaymentMethodCommand createPaymentMethodCommand);
}
