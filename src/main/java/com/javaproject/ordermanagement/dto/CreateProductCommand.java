package com.javaproject.ordermanagement.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class CreateProductCommand {

	@NotNull(message = "Please enter a number")
	private Long code;
	
	@NotEmpty(message="The field needs to be filled")
	@Length(min=2, max=120, message="Must contain between 2 and 120 characters")
	private String description;
	
	@NotNull(message="The field needs to be filled")
	@DecimalMin(value = "0.1", message = "Please Enter a valid value Amount ex: 0.1")
	private Double price;
	
	@NotNull(message="The field needs to be filled")
	@DecimalMin(value = "0.1", message = "Please Enter a valid value Amount ex: 0.1")
	private Double minPrince;
	
	@NotNull(message="The field needs to be filled")
	@DecimalMin(value = "0", message = "Please Enter a valid value Amount ex: 1")
	private Integer stockQuantity;
	
	public CreateProductCommand() {}

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
}
