package com.javaproject.ordermanagement.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

public class CreateOrderCommand {

	@NotNull
	private Long ClientId;

	private String moreInfo;

	private List<CreateOrderItemCommand> orderItems;

	public Long getClientId() {
		return ClientId;
	}

	public void setClientId(Long clientId) {
		ClientId = clientId;
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
