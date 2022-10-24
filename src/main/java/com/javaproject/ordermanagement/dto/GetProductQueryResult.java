package com.javaproject.ordermanagement.dto;

public class GetProductQueryResult {

	private Long id;
	private String description;
	private Double price;
	private Double minPrince;
	private Integer stockQuantity;

	public GetProductQueryResult() {
	}

	public GetProductQueryResult(Long id, String description, Double price, Double minPrince, Integer stockQuantity) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.minPrince = minPrince;
		this.stockQuantity = stockQuantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
