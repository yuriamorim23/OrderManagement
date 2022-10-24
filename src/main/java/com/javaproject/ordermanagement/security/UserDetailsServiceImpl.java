package com.javaproject.ordermanagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.javaproject.ordermanagement.entities.UserModel;
import com.javaproject.ordermanagement.repositories.UserModelRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserModelRepository userModelRepository;
	
	public UserDetailsServiceImpl(UserModelRepository userModelRepository) {
		this.userModelRepository = userModelRepository;
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userModel = userModelRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with name: " + username));
		return userModel;
	}
	
}