package com.javaproject.ordermanagement.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ProductUpdate {

	@NotEmpty(message="The field needs to be filled")
	@Length(min=2, max=120, message="Must contain between 2 and 120 characters")
	private String description;
	
	@NotEmpty(message="The field needs to be filled")
	@Length(min=4, max=120, message="Must contain minimum value 00,00")
	private Double price;
	
	@NotEmpty(message="The field needs to be filled")
	@Length(min=4, max=120, message="Must contain minimum value 00,00")
	private Double minPrince;
	
	@NotEmpty(message="The field needs to be filled")
	private Integer stockQuantity;

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
