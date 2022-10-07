package com.javaproject.ordermanagement.dto;

import javax.validation.constraints.NotNull;

public class CreatePaymentMethodCommand {

	@NotNull
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
