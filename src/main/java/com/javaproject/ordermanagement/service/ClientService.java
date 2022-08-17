package com.javaproject.ordermanagement.service;

import java.util.List;

import com.javaproject.ordermanagement.dto.CreateClientCommand;
import com.javaproject.ordermanagement.dto.GetClientQueryResult;
import com.javaproject.ordermanagement.dto.UpdateClientCommand;

public interface ClientService {

	List<GetClientQueryResult> findAll();

	GetClientQueryResult findById(Long id);

	GetClientQueryResult createClient(CreateClientCommand CreateClientCommand);

	GetClientQueryResult updateClient(UpdateClientCommand UpdateClientCommand, Long Id);

	void deleteById(Long id);

}