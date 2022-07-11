package com.javaproject.ordermanagement.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproject.ordermanagement.dto.ClientDTO;
import com.javaproject.ordermanagement.dto.ClientForm;
import com.javaproject.ordermanagement.dto.ClientUpdateForm;
import com.javaproject.ordermanagement.entities.Client;
import com.javaproject.ordermanagement.exception.ExceptionHandlerAdvice;
import com.javaproject.ordermanagement.repositories.ClientRepository;
import com.javaproject.ordermanagement.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public List<ClientDTO> findAll(){
		List<Client> all = repository.findAll();
		return convertListToDto(all);	
	}
	
	private static List<ClientDTO> convertListToDto(List<Client> clients){
		return clients.stream().map(ClientDTO::new).collect(Collectors.toList());
	}
	
	public ClientDTO findById(Long id) {
		Optional<Client> optional = repository.findById(id);
		if(optional.isPresent()) {
			return convertToDto(optional.get());
		}
		throw new ExceptionHandlerAdvice();
	}
	
	@Transactional
	public ClientDTO createClientCommand(ClientForm form) {
		Client client = convertToBusiness(form);
		client = repository.save(client);
		return convertToDto(client);
		
	}
	
	public ClientDTO UpdateClientCommand(ClientUpdateForm form, Long Id) {
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
	
	/*@Transactional
	public ClientDTO UpdateClientCommand(ClientUpdateForm form, Long id) {
        Optional<Client> client = repository.findById(id);
        if(client.isPresent()) {
        	Client obj = client.get();
        	if(form.getEmail() == null) {
        		throw new ExceptionHandlerAdvice();
        	}else {
        		obj.setEmail(form.getEmail());
        	}
        	if(form.getAddress() == null) {
        		throw new ExceptionHandlerAdvice();
        	}else {
        		obj.setAddress(form.getAddress());
        	}
        	repository.save(obj);
        	return convertToDto(obj);
        }
        return null;
	}*/

	public Client convertToBusiness(ClientForm form) {
		Client client = new Client();
		client.setFirstName(form.getFirstName());
		client.setLastName(form.getLastName());
		client.setAddress(form.getAddress());
		client.setPostCode(form.getPostCode());
		client.setPhoneNumber(form.getPhoneNumber());
		client.setEmail(form.getEmail());
		return client;
	}
	
	public ClientDTO convertToDto(Client client) {
		ClientDTO dto = new ClientDTO();
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