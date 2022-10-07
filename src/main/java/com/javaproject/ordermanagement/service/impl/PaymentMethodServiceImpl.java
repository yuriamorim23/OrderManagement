package com.javaproject.ordermanagement.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproject.ordermanagement.dto.BaseApiResult;
import com.javaproject.ordermanagement.dto.CreatePaymentMethodCommand;
import com.javaproject.ordermanagement.entities.PaymentMethod;
import com.javaproject.ordermanagement.repositories.PaymentMethodRepository;
import com.javaproject.ordermanagement.service.PaymentMethodService;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

	@Autowired
	private PaymentMethodRepository paymentMethodRepository;

	@Transactional
	public BaseApiResult paymentMethod(CreatePaymentMethodCommand createPaymentMethodCommand) {
		PaymentMethod paymentMethod = paymentMethodDto(createPaymentMethodCommand);
		paymentMethodRepository.save(paymentMethod);
		var result = new BaseApiResult(true, "created with success!");
		return result;
	}
	
	public PaymentMethod paymentMethodDto(CreatePaymentMethodCommand createPaymentMethodCommand) {
		PaymentMethod paymentMethod = new PaymentMethod();
		paymentMethod.setDescription(createPaymentMethodCommand.getDescription());
		return paymentMethod;
	}

}
