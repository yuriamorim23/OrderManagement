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
	
	
	
}
