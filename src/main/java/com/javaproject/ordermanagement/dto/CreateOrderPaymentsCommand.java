package com.javaproject.ordermanagement.dto;

import java.util.List;

public class CreateOrderPaymentsCommand {

	//@NotNull(message = "The field needs to be filled")
	private Long orderId;
	
	private List<CreateOrderPaymentsListCommand> orderPaymentsList;
	
	public CreateOrderPaymentsCommand() {}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public List<CreateOrderPaymentsListCommand> getOrderPaymentsList() {
		return orderPaymentsList;
	}

	public void setOrderPaymentsList(List<CreateOrderPaymentsListCommand> orderPaymentsList) {
		this.orderPaymentsList = orderPaymentsList;
	}
	
}
