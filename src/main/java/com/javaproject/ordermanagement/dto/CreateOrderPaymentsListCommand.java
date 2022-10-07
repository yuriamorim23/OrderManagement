package com.javaproject.ordermanagement.dto;

public class CreateOrderPaymentsListCommand {

	private Long paymentId;

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
