package com.javaproject.ordermanagement.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "client")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(unique = true)
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date created;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date updated;
	
	private String firstName;
	private String lastName;
	private String address;
	private String postCode;
	private String phoneNumber; 
	private String email;
	
	public Client() {}

	public Client(UUID id, Date created, Date updated, String firstName, String lastName, String address,
			String postCode, String phoneNumber, String email) {
		this.id = id;
		this.created = created;
		this.updated = updated;
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

	public Date getCreated() {
		return created;
	}

	public Date setCreated(Date created) {
		return this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public Date setUpdated(Date updated) {
		return this.updated = updated;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}
}
