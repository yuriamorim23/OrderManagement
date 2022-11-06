package com.javaproject.ordermanagement.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.javaproject.ordermanagement.enums.UserRoles;

public class CreateUserModelCommand {

	@NotEmpty(message = "The field needs to be filled")
	@Length(min = 5, max = 120, message = "Must contain between 5 and 120 characters")
	private String username;

	@NotEmpty(message = "The field needs to be filled")
	private String password;

	private Set<UserRoles> roles = new HashSet<UserRoles>();

	public CreateUserModelCommand(String username, String password, Set<UserRoles> userRoles) {
		this.username = username;
		this.password = password;
		this.roles = userRoles;
	}

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

	public Set<UserRoles> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRoles> roles) {
		this.roles = roles;
	}

}
