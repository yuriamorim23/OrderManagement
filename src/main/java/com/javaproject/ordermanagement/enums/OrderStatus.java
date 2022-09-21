package com.javaproject.ordermanagement.enums;

public enum OrderStatus {

	OPEN(1, "Open"),
	SOLD(2, "Sold"),
	CLOSED(3, "Closed");
	
	private int code; 
	private String descricao;
	
	
	private OrderStatus(int code, String descricao) {
		this.code = code;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return code;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
