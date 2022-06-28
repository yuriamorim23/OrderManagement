package com.javaproject.ordermanagement.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproject.ordermanagement.DTO.ClientDTO;
import com.javaproject.ordermanagement.DTO.ClientUpdateForm;
import com.javaproject.ordermanagement.DTO.UserForm;
import com.javaproject.ordermanagement.Entities.Client;
import com.javaproject.ordermanagement.Repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public List<ClientDTO> Get(){
		List<Client> all = repository.findAll();
		return convertListToDto(all);
	}
	
	public ClientDTO GetById(Long id) {
		Optional<Client> optional = repository.findById(id);
		if(optional.isPresent()) {
			return convertToDto(optional.get());
		}
		return null;
	}
	
	public ClientDTO CreateClientCommand(UserForm form) {
		Client client = convertToBusiness(form);
		client = repository.save(client);
		return convertToDto(client);
	}
	
	public ClientDTO UpdateClientCommand(ClientUpdateForm form, Long Id) {
		Optional<Client> op = repository.findById(Id);
		if(op.isPresent()) {
			Client obj = op.get();
			if(form.getAddress() != null) {
				obj.setAddress(form.getAddress());
			}
			if(form.getPostCode() != null) {
				obj.setPostCode(form.getPostCode());
			}else if(form.getPhoneNumber() != null) {
				obj.setPhoneNumber(form.getPhoneNumber());
			}if(form.getEmail() != null) {
				obj.setEmail(form.getEmail());
			}
			repository.save(obj);
			return convertToDto(obj);
		}
		return null;
	}
	
	public void deleteById(Long id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
		}
	}
	
	public Client convertToBusiness(UserForm form) {
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
		dto.setFirstName(client.getFirstName());
		dto.setLastName(client.getLastName());
		dto.setAddress(client.getAddress());
		dto.setPostCode(client.getPostCode());
		dto.setPhoneNumber(client.getPhoneNumber());
		dto.setEmail(client.getEmail());
		return dto;
	}
	
	public static List<ClientDTO> convertListToDto(List<Client> clients){
		return clients.stream().map(ClientDTO::new).collect(Collectors.toList());
	}
}