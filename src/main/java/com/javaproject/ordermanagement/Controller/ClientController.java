package com.javaproject.ordermanagement.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.ordermanagement.Entity.Client;
import com.javaproject.ordermanagement.Service.ClientService;

@RestController
@RequestMapping(value="/client")
public class ClientController {

	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<Client>> getAllClients(){
		return ResponseEntity.ok(service.findAll());
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Client> inserindoNoBanco(@Valid @RequestBody Client qualquerNome) {
		return new ResponseEntity<>(service.inserindoNoBanco(qualquerNome), HttpStatus.CREATED);
	}
}

/*@GetMapping
public ResponseEntity<Client> findAll(){
	
	Client cl1 = new Client(1,"Yuri", "Amorim", "200 Drive Road", "WN12NV", "7893251469", "yuri@gmail.com");
	return ResponseEntity.ok().body(cl1);
	
}

}*/

/* @GetMapping
		public List<Client> clientList(){
			
			Client cl1 = new Client("Yuri", "Amorim", "200 Drive Road", "WN12NV", "7893251469", "yuri@gmail.com");
			
			List<Client> clList = new ArrayList<>();
			clList.add(cl1);
			
			
			return clList;*/

/*@GetMapping
public List<Client> getAllClients() {
    return service.findAll();
}*/

/*@GetMapping
public ResponseEntity<List<Client>> findAll() {
    List<Client> result = service.findAll();
    return ResponseEntity.ok(result);
}*/


/*@GetMapping
public List<Client> getAllClients() {
    return service.findAll();
}*/

/*ANTIGO METODO POST
@RequestMapping(method=RequestMethod.POST)
public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDTO objDto) {
	Cliente obj = service.fromDTO(objDto);
	obj = service.insert(obj);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
	return ResponseEntity.created(uri).build();
}*/