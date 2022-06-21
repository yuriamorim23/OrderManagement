package com.javaproject.ordermanagement.Service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproject.ordermanagement.Entity.Client;
import com.javaproject.ordermanagement.Repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll() {
	    return repository.findAll();
	}
	
	@Transactional
	public Client inserindoNoBanco(Client objeto1) {
		objeto1.setCreated(new Date());
		objeto1.setUpdated(new Date());
		return repository.save(objeto1);
		
	}
	
	/*@Transactional
	public Client qualquerNome3(Client qualquerNome5) {
		Client var1 = new Client(null, 
				qualquerNome5.setCreated(new Date()), 
				qualquerNome5.setUpdated(new Date()), 
				qualquerNome5.getFirstName(), 
				qualquerNome5.getLastName(), 
				qualquerNome5.getAddress(), 
				qualquerNome5.getPostCode(), 
				qualquerNome5.getPhoneNumber(),
				qualquerNome5.getEmail());
		return var1;
		
	}*/
	
}
