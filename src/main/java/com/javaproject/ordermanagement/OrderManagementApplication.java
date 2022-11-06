package com.javaproject.ordermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.javaproject.ordermanagement.configurations.RsaKeyProperties;

@EnableWebMvc
@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class OrderManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementApplication.class, args);
	}
	
}
