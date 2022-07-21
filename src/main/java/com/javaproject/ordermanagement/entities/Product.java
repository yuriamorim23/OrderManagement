package com.javaproject.ordermanagement.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(unique = true)
	private Long code;
	private String description;
	private Double price;
	private Double minPrince;
	private Integer stockQuantity;
	
	public Product() {}

	public Product(Long id, Long code, String description, Double price, Double minPrince, Integer stockQuantity) {
		super();
		this.id = id;
		this.code = code;
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
