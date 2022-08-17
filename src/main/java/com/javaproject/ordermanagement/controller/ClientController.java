package com.javaproject.ordermanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.javaproject.ordermanagement.dto.GetClientQueryResult;
import com.javaproject.ordermanagement.dto.CreateClientCommand;
import com.javaproject.ordermanagement.dto.UpdateClientCommand;

public interface ClientController {

	ResponseEntity<List<GetClientQueryResult>> findAll();

	ResponseEntity<GetClientQueryResult> findById(@PathVariable("id") Long id);
	
	ResponseEntity<GetClientQueryResult> register(@RequestBody @Valid CreateClientCommand createClientCommand);
	
	GetClientQueryResult updateById(@RequestBody UpdateClientCommand updateClientCommand, @PathVariable("id") Long id);
	
	void deleteById(@PathVariable("id") Long id);

}