package com.javaproject.ordermanagement.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproject.ordermanagement.dto.GetClientQueryResult;
import com.javaproject.ordermanagement.dto.CreateClientCommand;
import com.javaproject.ordermanagement.dto.UpdateClientCommand;
import com.javaproject.ordermanagement.entities.Client;
import com.javaproject.ordermanagement.exception.ExceptionHandlerAdvice;
import com.javaproject.ordermanagement.repositories.ClientRepository;
import com.javaproject.ordermanagement.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public List<GetClientQueryResult> findAll(){
		List<Client> all = repository.findAll();
		return convertListToDto(all);	
	}
	
	private static List<GetClientQueryResult> convertListToDto(List<Client> clients){
		return clients.stream().map(GetClientQueryResult::new).collect(Collectors.toList());
	}
	
	@Transactional
	public GetClientQueryResult findById(Long id) {
		Optional<Client> optional = repository.findById(id);
		if(optional.isPresent()) {
			return convertToDto(optional.get());
		}
		throw new ExceptionHandlerAdvice();
	}
	
	@Transactional
	public GetClientQueryResult createClientCommand(CreateClientCommand form) {
		Client client = convertToBusiness(form);
		client = repository.save(client);
		return convertToDto(client);
	}
	
	@Transactional
	public GetClientQueryResult UpdateClientCommand(UpdateClientCommand form, Long Id) {
		Optional<Client> op = repository.findById(Id);
		if(op.isPresent()) {
			Client obj = op.get();
			if(form.getAddress()  != null 
					&& form.getPostCode() != null 
					&& form.getPhoneNumber() != null 
					&& form.getEmail() != null) {
				obj.setAddress(form.getAddress());
				obj.setPostCode(form.getPostCode());
				obj.setPhoneNumber(form.getPhoneNumber());
				obj.setEmail(form.getEmail());
			}
			repository.save(obj);
			return convertToDto(obj);
		}
		return null;
	}

	@Transactional
	public void deleteById(Long id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
		}else {
			throw new ExceptionHandlerAdvice();
		}
	}
	
	public Client convertToBusiness(CreateClientCommand form) {
		Client client = new Client();
		client.setFirstName(form.getFirstName());
		client.setLastName(form.getLastName());
		client.setAddress(form.getAddress());
		client.setPostCode(form.getPostCode());
		client.setPhoneNumber(form.getPhoneNumber());
		client.setEmail(form.getEmail());
		return client;
	}
	
	public GetClientQueryResult convertToDto(Client client) {
		GetClientQueryResult dto = new GetClientQueryResult();
		dto.setId(client.getId());
		dto.setFirstName(client.getFirstName());
		dto.setLastName(client.getLastName());
		dto.setAddress(client.getAddress());
		dto.setPostCode(client.getPostCode());
		dto.setPhoneNumber(client.getPhoneNumber());
		dto.setEmail(client.getEmail());
		return dto;
	}
}