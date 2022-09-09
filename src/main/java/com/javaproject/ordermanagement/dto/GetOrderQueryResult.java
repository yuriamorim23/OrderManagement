package com.javaproject.ordermanagement.dto;

import com.javaproject.ordermanagement.enums.OrderStatus;

public class GetOrderQueryResult {

	private Long clientId;
	private Long orderId;
	private String clientName;
	private String moreInfo;
	private OrderStatus status;
	private Double total;
	
	public GetOrderQueryResult() {}

	public GetOrderQueryResult(Long clientId, Long orderId, String clientName, String moreInfo, OrderStatus status,
			Double total) {
		super();
		this.clientId = clientId;
		this.orderId = orderId;
		this.clientName = clientName;
		this.moreInfo = moreInfo;
		this.status = status;
		this.total = total;
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

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
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

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
}
