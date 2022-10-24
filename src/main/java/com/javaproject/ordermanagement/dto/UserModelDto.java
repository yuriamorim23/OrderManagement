package com.javaproject.ordermanagement.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class UserModelDto {

	@NotEmpty(message = "The field needs to be filled")
	@Length(min = 5, max = 120, message = "Must contain between 5 and 120 characters")
	private String username;

	@NotEmpty(message = "The field needs to be filled")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
