package com.javaproject.ordermanagement.service;

import com.javaproject.ordermanagement.dto.BaseApiResult;
import com.javaproject.ordermanagement.dto.UserModelDto;

public interface UserModelService {

	BaseApiResult createUserModel(UserModelDto userModelDto);
	
}
