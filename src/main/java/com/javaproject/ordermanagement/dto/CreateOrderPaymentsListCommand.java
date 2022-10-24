package com.javaproject.ordermanagement.dto;

import javax.validation.constraints.NotNull;

public class CreateOrderPaymentsListCommand {

	@NotNull(message = "The field needs to be filled")
	private Long paymentId;

	@NotNull(message = "The field needs to be filled")
	private Double value;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
