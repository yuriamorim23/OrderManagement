package com.javaproject.ordermanagement.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.javaproject.ordermanagement.dto.BaseApiResult;
import com.javaproject.ordermanagement.dto.UserModelDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public interface UserModelController {
	
	ResponseEntity<BaseApiResult> createUser(@RequestBody @Valid UserModelDto userModelDto);
	

}
