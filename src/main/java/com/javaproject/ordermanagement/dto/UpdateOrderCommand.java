package com.javaproject.ordermanagement.dto;

import com.javaproject.ordermanagement.enums.OrderStatus;

public class UpdateOrderCommand {
	
	private OrderStatus status;

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
}
