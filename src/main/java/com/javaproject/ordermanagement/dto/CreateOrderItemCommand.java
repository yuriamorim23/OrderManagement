package com.javaproject.ordermanagement.dto;

import javax.validation.constraints.NotNull;

public class CreateOrderItemCommand {

	@NotNull
	private Long productId;

	@NotNull
	private Double price;

	@NotNull
	private Integer quantity;

	public CreateOrderItemCommand() {
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return price * quantity;
	}

}
