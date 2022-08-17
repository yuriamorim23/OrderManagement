package com.javaproject.ordermanagement.dto;

import javax.validation.constraints.NotNull;

import com.javaproject.ordermanagement.enums.OrderStatus;

public class CreateOrderCommand {

	@NotNull
	private Long Client;

	private String moreInfo;

	@NotNull(message = "The field needs to be filled")
	private OrderStatus status;

	public Long getClient() {
		return Client;
	}

	public void setClient(Long client) {
		Client = client;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

}
