package com.javaproject.ordermanagement.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.ordermanagement.controller.ClientController;
import com.javaproject.ordermanagement.dto.CreateClientCommand;
import com.javaproject.ordermanagement.dto.GetClientQueryResult;
import com.javaproject.ordermanagement.dto.UpdateClientCommand;
import com.javaproject.ordermanagement.service.ClientService;

@RestController
@RequestMapping(value = "api/v1/client")
public class ClientControllerImpl implements ClientController {

	@Autowired
	private ClientService service;

	@GetMapping
	public ResponseEntity<List<GetClientQueryResult>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<GetClientQueryResult> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<GetClientQueryResult> createClient(
			@RequestBody @Valid CreateClientCommand createClientCommand) {
		return new ResponseEntity<>(service.createClient(createClientCommand), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<GetClientQueryResult> updateClient(
			@RequestBody @Valid UpdateClientCommand updateClientCommand, @PathVariable("id") Long id) {
		return new ResponseEntity<>(service.updateClient(updateClientCommand, id), HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		service.deleteById(id);
	}

}