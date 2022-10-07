package com.javaproject.ordermanagement.service;

import com.javaproject.ordermanagement.dto.BaseApiResult;
import com.javaproject.ordermanagement.dto.CreatePaymentMethodCommand;

public interface PaymentMethodService {

	BaseApiResult paymentMethod(CreatePaymentMethodCommand createPaymentMethodCommand);
}
