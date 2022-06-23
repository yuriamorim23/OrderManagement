package com.javaproject.ordermanagement.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.ordermanagement.DTO.ClientDTO;
import com.javaproject.ordermanagement.DTO.ClientUpdateForm;
import com.javaproject.ordermanagement.DTO.UserForm;
import com.javaproject.ordermanagement.Service.ClientService;

@RestController
@RequestMapping(value="api/v1/client")
public class ClientController {

	@Autowired
	private ClientService service;
			
	@GetMapping
	public List<ClientDTO> list(){
		return service.Get();
	}
	
	@GetMapping("/{id}")
	public ClientDTO FindById(@PathVariable("id") Long id){
		return service.GetById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ClientDTO Register(@RequestBody @Valid UserForm userForm) {
		return service.CreateClientCommand(userForm);
	}
	
	@PutMapping("/{id}")
	public ClientDTO updateById(@RequestBody ClientUpdateForm form, @PathVariable("id") Long id) {
		return service.UpdateClientCommand(form, id);
	}
	
	@DeleteMapping
	public void deleteById(@PathVariable("id") Long id) {
		service.deleteById(id);
	}	
}