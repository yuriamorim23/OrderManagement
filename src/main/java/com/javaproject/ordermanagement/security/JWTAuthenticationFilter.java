package com.javaproject.ordermanagement.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaproject.ordermanagement.dto.UserCredentials;

public class JWTAuthenticationFilter extends AbstractHttpConfigurer<JWTAuthenticationFilter, HttpSecurity> {
	
    private JWTUtil jwtUtil;
    		
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }
    
	
	public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res, HttpSecurity http) throws AuthenticationException {
		final AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
		try {
			UserCredentials creds = new ObjectMapper()
	                .readValue(req.getInputStream(), UserCredentials.class);	        
	        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	        		creds.getUsername(),
	        		creds.getPassword(),
	        		new ArrayList<>()));
	        
	        return auth;
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
	
		String username = ((UserSS) auth.getPrincipal()).getUsername();
        String token = jwtUtil.generateToken(username);
        res.addHeader("Authorization", "Bearer " + token);
        res.addHeader("access-control-expose-headers", "Authorization");
	}

}
