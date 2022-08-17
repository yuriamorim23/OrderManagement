package com.javaproject.ordermanagement.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.javaproject.ordermanagement.entities.Client;
import com.javaproject.ordermanagement.entities.Order;
import com.javaproject.ordermanagement.enums.OrderStatus;

public class GetOrderQueryResult {

	private Client Client;
	private String moreInfo;
	private OrderStatus status;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date closeSoldDate;

	public GetOrderQueryResult() {
	}

	public GetOrderQueryResult(Order order) {
		this.Client = order.getClient();
		this.moreInfo = order.getMoreInfo();
		this.status = order.getStatus();
		this.closeSoldDate = order.getCloseSoldDate();
	}

	public Client getClient() {
		return Client;
	}

	public void setClient(Client client) {
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

	public Date getCloseSoldDate() {
		return closeSoldDate;
	}

	public void setCloseSoldDate(Date closeSoldDate) {
		this.closeSoldDate = closeSoldDate;
	}

	
}
