package com.javaproject.ordermanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.javaproject.ordermanagement.dto.BaseApiResult;
import com.javaproject.ordermanagement.dto.CreateUserModelCommand;
import com.javaproject.ordermanagement.dto.GetUserModelQueryResult;
import com.javaproject.ordermanagement.entities.UserModel;
import com.javaproject.ordermanagement.repositories.UserModelRepository;
import com.javaproject.ordermanagement.service.UserModelService;

@Service
public class UserModelServiceImpl implements UserModelService {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserModelRepository userModelRepository;
	
	public List<GetUserModelQueryResult> findAll() {
		List<UserModel> userModelList = userModelRepository.findAll();
		List<GetUserModelQueryResult> userModelResult = new ArrayList<GetUserModelQueryResult>();

		userModelList.forEach(list -> {
			userModelResult.add(new GetUserModelQueryResult(list.getUsername(), list.getPassword(), list.getUserRoles()));
		});

		return userModelResult;
	}
	
	@Transactional
	public BaseApiResult createUserModel(CreateUserModelCommand userModelDto) {
		UserModel userModel = toDto(userModelDto);
		userModelRepository.save(userModel);
		return new BaseApiResult(true, "User created with success!");
	}

	public UserModel toDto(CreateUserModelCommand userModelDto) {
		UserModel userModel = new UserModel();
		userModel.setUsername(userModelDto.getUsername());
		userModel.setPassword(passwordEncoder.encode(userModelDto.getPassword()));
		return userModel;
	}
	
}

/*public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
UserModel userModel = userModelRepository.findByUserName(username)
		.orElseThrow(() -> new UsernameNotFoundException("User not found with name: " + username));
return userModel;
}*/

/*@Transactional
public UserModel findByUserName(String userName) {
UserModel userModel = userModelRepository.findByUserName(userName)
		.orElseThrow(() -> new ErrorAdvice("User not found with name: " + userName));
return userModel;
}*/