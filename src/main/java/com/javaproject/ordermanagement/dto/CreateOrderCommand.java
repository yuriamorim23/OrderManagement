package com.javaproject.ordermanagement.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

public class CreateOrderCommand {

	@NotNull
	private Long Client;

	private String moreInfo;
	
	private List<CreateOrderItemCommand> orderItems;

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

	public List<CreateOrderItemCommand> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<CreateOrderItemCommand> orderItems) {
		this.orderItems = orderItems;
	}
	
}
