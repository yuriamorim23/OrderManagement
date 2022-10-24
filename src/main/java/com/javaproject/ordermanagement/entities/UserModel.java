package com.javaproject.ordermanagement.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.javaproject.ordermanagement.enums.UserRoles;

@Entity
@Table(name = "UserModel")
public class UserModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String username;

	@Column
	private String password;
	
	public UserModel() {
		addRoles(UserRoles.USER);
	}

	public UserModel(String username, String password, Set<Integer> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
		addRoles(UserRoles.USER);
	}

	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "UserRoles")
	private Set<Integer> roles = new HashSet<Integer>();
	
	public Set<UserRoles> getUserRoles(){
		return roles.stream().map(x -> UserRoles.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addRoles(UserRoles userRoles) {
		roles.add(userRoles.getCod());
	}

	public String getPassword() {
		return this.password;
	}

	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
