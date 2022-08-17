package com.javaproject.ordermanagement.dto;

import com.javaproject.ordermanagement.entities.Client;

public class GetClientQueryResult {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private String postCode;
	private String phoneNumber; 
	private String email;
	
	public GetClientQueryResult() {}
	
	public GetClientQueryResult(Client client) {
		this.id = client.getId();
		this.firstName = client.getFirstName();
		this.lastName = client.getLastName();
		this.address = client.getAddress();
		this.postCode = client.getPostCode();
		this.phoneNumber = client.getPhoneNumber();
		this.email = client.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
