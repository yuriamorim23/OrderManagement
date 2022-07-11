package com.javaproject.ordermanagement.service;

import java.util.List;

import com.javaproject.ordermanagement.dto.ClientDTO;
import com.javaproject.ordermanagement.dto.ClientForm;
import com.javaproject.ordermanagement.dto.ClientUpdateForm;

public interface ClientService {

	List<ClientDTO> findAll();

	ClientDTO findById(Long id);
	
	ClientDTO createClientCommand(ClientForm form);

	ClientDTO UpdateClientCommand(ClientUpdateForm form, Long Id);

}