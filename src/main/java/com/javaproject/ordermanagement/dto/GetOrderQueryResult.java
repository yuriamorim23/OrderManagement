package com.javaproject.ordermanagement.dto;

import com.javaproject.ordermanagement.enums.OrderStatus;

public class GetOrderQueryResult {

	private Long clientId;
	private Long orderId;
	private String moreInfo;
	private OrderStatus status;
	
	public GetOrderQueryResult() {}

	public GetOrderQueryResult(Long clientId, Long orderId, String moreInfo, OrderStatus status) {
		super();
		this.clientId = clientId;
		this.orderId = orderId;
		this.moreInfo = moreInfo;
		this.status = status;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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
