package com.javaproject.ordermanagement.dto;

import java.util.HashSet;
import java.util.Set;

import com.javaproject.ordermanagement.enums.UserRoles;

public class GetUserModelQueryResult {

	private String username;

	private String password;

	private Set<UserRoles> roles = new HashSet<UserRoles>();

	public GetUserModelQueryResult(String username, String password, Set<UserRoles> userRoles) {
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