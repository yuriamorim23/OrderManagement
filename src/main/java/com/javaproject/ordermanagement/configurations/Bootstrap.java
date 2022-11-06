package com.javaproject.ordermanagement.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.javaproject.ordermanagement.entities.UserModel;
import com.javaproject.ordermanagement.repositories.UserModelRepository;

@Component
public class Bootstrap implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	UserModelRepository userRepository;
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		createUserAdmin();
	}

	private void createUserAdmin() {
		if(userRepository.findByUsername("admin").isEmpty()) {
			var user = new UserModel();
			user.setUsername("admin");
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);
		}
	}

}
