package com.javaproject.ordermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javaproject.ordermanagement.entities.UserModel;
import com.javaproject.ordermanagement.repositories.UserModelRepository;
import com.javaproject.ordermanagement.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserModelRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = repo.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserSS(user.getUsername(), user.getPassword(), user.getUserRoles());
	}

}
