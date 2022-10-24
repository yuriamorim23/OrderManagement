package com.javaproject.ordermanagement.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.ordermanagement.dto.UserCredentials;
import com.javaproject.ordermanagement.security.JWTUtil;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class LoginControllerImpl {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@PostMapping("/login")
	ResponseEntity<String> login(@RequestBody UserCredentials userCredentials) {
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userCredentials.getUsername(),
				userCredentials.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String toke = jwtUtil.generateToken(userCredentials.getUsername());
		return ResponseEntity.ok(toke);

	}
}
