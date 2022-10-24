package com.javaproject.ordermanagement.service;

import java.util.List;

import com.javaproject.ordermanagement.dto.BaseApiResult;
import com.javaproject.ordermanagement.dto.CreateUserModelCommand;
import com.javaproject.ordermanagement.dto.GetUserModelQueryResult;

public interface UserModelService {

	List<GetUserModelQueryResult> findAll();
	
	BaseApiResult createUserModel(CreateUserModelCommand userModelDto);
	
}
