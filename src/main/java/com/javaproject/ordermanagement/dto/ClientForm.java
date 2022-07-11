package com.javaproject.ordermanagement.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ClientForm {
	
	@NotEmpty(message="The field needs to be filled")
	@Length(min=5, max=120, message="Must contain between 5 and 120 characters")
	private String firstName;
	
	@NotEmpty(message="The field needs to be filled")
	@Length(min=5, max=120, message="Must contain between 5 and 120 characters")
	private String lastName;
	
	@NotEmpty(message="The field needs to be filled")
	private String address;
	
	@NotEmpty(message="The field needs to be filled")
	private String postCode;
	
	@Length(min=10, message="Must contain at least 10 characters")
	private String phoneNumber; 
	
	@NotEmpty(message="The field needs to be filled")
	@Length(min=5, max=120, message="Must contain between 5 and 120 characters")
	@Email(message="Invalid email")
	private String email;
	
	public ClientForm() {}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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
