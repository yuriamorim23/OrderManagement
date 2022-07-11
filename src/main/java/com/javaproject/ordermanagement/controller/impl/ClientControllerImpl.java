package com.javaproject.ordermanagement.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.ordermanagement.controller.ClientController;
import com.javaproject.ordermanagement.dto.ClientDTO;
import com.javaproject.ordermanagement.dto.ClientForm;
import com.javaproject.ordermanagement.dto.ClientUpdateForm;
import com.javaproject.ordermanagement.service.ClientService;

@RestController
@RequestMapping(value="api/v1/")
public class ClientControllerImpl implements ClientController {

	@Autowired
	private ClientService service;
	
	@GetMapping("/client")
	public ResponseEntity<List<ClientDTO>> findAll(){
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("client/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable("id") Long id){
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@PostMapping("/client")
	public ResponseEntity<ClientDTO> register(@RequestBody @Valid ClientForm form) {
		return new ResponseEntity<>(service.createClientCommand(form), HttpStatus.CREATED);
	}

	@PutMapping("client/{id}")
	public ClientDTO updateById(@RequestBody @Valid ClientUpdateForm form, @PathVariable("id") Long id) {
		return service.UpdateClientCommand(form, id);
	}
	
}	