package com.javaproject.ordermanagement.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproject.ordermanagement.dto.CreateClientCommand;
import com.javaproject.ordermanagement.dto.GetClientQueryResult;
import com.javaproject.ordermanagement.dto.UpdateClientCommand;
import com.javaproject.ordermanagement.entities.Client;
import com.javaproject.ordermanagement.exception.ExceptionHandlerAdvice;
import com.javaproject.ordermanagement.repositories.ClientRepository;
import com.javaproject.ordermanagement.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository repository;

	public List<GetClientQueryResult> findAll() {
		List<Client> all = repository.findAll();
		return convertListToDto(all);
	}

	private static List<GetClientQueryResult> convertListToDto(List<Client> clients) {
		return clients.stream().map(GetClientQueryResult::new).collect(Collectors.toList());
	}

	@Transactional
	public GetClientQueryResult findById(Long id) {
		Optional<Client> optional = repository.findById(id);
		if (optional.isPresent()) {
			return convertToDto(optional.get());
		}
		throw new ExceptionHandlerAdvice();
	}

	@Transactional
	public GetClientQueryResult createClient(CreateClientCommand createClientCommand) {
		Client client = convertToBusiness(createClientCommand);
		client = repository.save(client);
		return convertToDto(client);
	}

	@Transactional
	public GetClientQueryResult updateClient(UpdateClientCommand updateClientCommand, Long Id) {
		Optional<Client> op = repository.findById(Id);
		if (op.isPresent()) {
			Client obj = op.get();
			if (updateClientCommand.getAddress() != null && updateClientCommand.getPostCode() != null
					&& updateClientCommand.getPhoneNumber() != null && updateClientCommand.getEmail() != null) {
				obj.setAddress(updateClientCommand.getAddress());
				obj.setPostCode(updateClientCommand.getPostCode());
				obj.setPhoneNumber(updateClientCommand.getPhoneNumber());
				obj.setEmail(updateClientCommand.getEmail());
			}
			repository.save(obj);
			return convertToDto(obj);
		}
		return null;
	}

	@Transactional
	public void deleteById(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			throw new ExceptionHandlerAdvice();
		}
	}

	public Client convertToBusiness(CreateClientCommand createClientCommand) {
		Client client = new Client();
		client.setFirstName(createClientCommand.getFirstName());
		client.setLastName(createClientCommand.getLastName());
		client.setAddress(createClientCommand.getAddress());
		client.setPostCode(createClientCommand.getPostCode());
		client.setPhoneNumber(createClientCommand.getPhoneNumber());
		client.setEmail(createClientCommand.getEmail());
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