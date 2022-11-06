package com.javaproject.ordermanagement.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.ordermanagement.controller.UserModelController;
import com.javaproject.ordermanagement.dto.BaseApiResult;
import com.javaproject.ordermanagement.dto.CreateUserModelCommand;
import com.javaproject.ordermanagement.dto.GetUserModelQueryResult;
import com.javaproject.ordermanagement.service.UserModelService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "api/v1/user")
public class UserModelControllerImpl implements UserModelController {

	@Autowired
	private UserModelService service;

	@PostMapping("/newuser")
	public ResponseEntity<BaseApiResult> createUser(@RequestBody @Valid CreateUserModelCommand userModelDto) {
		return new ResponseEntity<>(service.createUserModel(userModelDto), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<GetUserModelQueryResult>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

}