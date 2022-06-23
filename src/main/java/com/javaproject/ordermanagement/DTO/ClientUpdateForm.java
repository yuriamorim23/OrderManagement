package com.javaproject.ordermanagement.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ClientUpdateForm {
	
	@NotBlank(message = "Field cannot be blank")
	private String address;
	private String postCode;
	private String phoneNumber;
	
	@Email(message = "Invalid email")
	private String email;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
