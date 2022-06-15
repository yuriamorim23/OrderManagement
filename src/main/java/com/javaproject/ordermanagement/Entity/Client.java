package com.javaproject.ordermanagement.Entity;

import java.io.Serializable;
import java.util.UUID;


public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private UUID id;
	
	private String firstName;
	private String lastName;
	private String address;
	private String postCode;
	private String phoneNumber; 
	private String email;
	
	
	public Client(UUID id, String firstName, String lastName, String address, String postCode, String phoneNumber,
			String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.postCode = postCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
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
