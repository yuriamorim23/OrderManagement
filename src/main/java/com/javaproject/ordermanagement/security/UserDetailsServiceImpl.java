package com.javaproject.ordermanagement.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javaproject.ordermanagement.entities.UserModel;
import com.javaproject.ordermanagement.repositories.UserModelRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	final UserModelRepository userModelRepository;

	public UserDetailsServiceImpl(UserModelRepository userModelRepository) {
		super();
		this.userModelRepository = userModelRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userModel = userModelRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with name: " + username));
		return new UserModel(userModel.getUsername(), userModel.getPassword(), userModel.getRoles());
	}

}
