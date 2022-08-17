package com.javaproject.ordermanagement.dto;

import com.javaproject.ordermanagement.entities.Product;

public class GetProductQueryResult {
	
	private Long id;
	private Long code;
	private String description;
	private Double price;
	private Double minPrince;
	private Integer stockQuantity;
	
	public GetProductQueryResult() {}
	
	public GetProductQueryResult(Product product) {
		this.setId(product.getId());
		this.code = product.getCode();
		this.description = product.getDescription();
		this.price = product.getPrice();
		this.minPrince = product.getMinPrince();
		this.stockQuantity = product.getStockQuantity();
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getMinPrince() {
		return minPrince;
	}

	public void setMinPrince(Double minPrince) {
		this.minPrince = minPrince;
	}

	public Integer getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
