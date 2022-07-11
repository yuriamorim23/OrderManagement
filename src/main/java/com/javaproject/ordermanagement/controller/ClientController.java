package com.javaproject.ordermanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.javaproject.ordermanagement.dto.ClientDTO;
import com.javaproject.ordermanagement.dto.ClientForm;
import com.javaproject.ordermanagement.dto.ClientUpdateForm;

public interface ClientController {

	ResponseEntity<List<ClientDTO>> findAll();

	ResponseEntity<ClientDTO> findById(@PathVariable("id") Long id);
	
	ResponseEntity<ClientDTO> register(@RequestBody @Valid ClientForm form);
	
	/*ResponseEntity<ClientDTO> updateById(@RequestBody ClientUpdateForm form, @PathVariable("id") Long id);*/
	
	ClientDTO updateById(@RequestBody ClientUpdateForm form, @PathVariable("id") Long id);

}