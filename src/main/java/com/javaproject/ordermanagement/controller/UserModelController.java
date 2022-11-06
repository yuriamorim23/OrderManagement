package com.javaproject.ordermanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.javaproject.ordermanagement.dto.BaseApiResult;
import com.javaproject.ordermanagement.dto.CreateUserModelCommand;
import com.javaproject.ordermanagement.dto.GetUserModelQueryResult;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public interface UserModelController {
	
	ResponseEntity<List<GetUserModelQueryResult>> findAll();

	ResponseEntity<BaseApiResult> createUser(@RequestBody @Valid CreateUserModelCommand userModelDto);

}
