package com.javaproject.ordermanagement.dto;

import javax.validation.constraints.NotNull;

public class CreateOrderItemCommand {

	@NotNull
	private Long productId;

	@NotNull
	private Double price;

	@NotNull
	private Double quantity;

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

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

}
