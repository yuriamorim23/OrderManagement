package com.javaproject.ordermanagement.dto;

import javax.validation.constraints.NotNull;

import com.javaproject.ordermanagement.entities.Product;

public class CreateOrderItemCommand {

	@NotNull
	private Product productId;
	
	@NotNull
	private Double price;
	
	@NotNull
	private Double quantity;
	
	public CreateOrderItemCommand () {}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
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
