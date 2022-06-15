package com.javaproject.ordermanagement.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/client")
public class ClientController {

		

	
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
