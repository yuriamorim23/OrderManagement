package com.javaproject.ordermanagement.enums;

public enum OrderStatus {

	OPEN(1, "Open"),
	SOLD(2, "Sold"),
	CLOSED(3, "Closed");
	
	private int code; 
	private String description;
	
	
	private OrderStatus(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCod() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
}
