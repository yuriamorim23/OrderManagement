package com.javaproject.ordermanagement.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

public class CreateOrderCommand {

	@NotNull
	private Long clientId;
	
	private String clientName;

	private String moreInfo;

	private List<CreateOrderItemCommand> orderItems;

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
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

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	public double getValorTotal() {
		double soma = 0.0;
		for (CreateOrderItemCommand ip : orderItems) {
			soma = soma + ip.getOrderTotal();
		}
		return soma;
	}

}
