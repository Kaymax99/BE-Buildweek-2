package com.BEBuildweek2.controller;


import java.util.List;

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

import com.BEBuildweek2.model.Client;
import com.BEBuildweek2.service.ClientService;


public class ClientController {
	
	



	@RestController
	@RequestMapping("/clients")
	public class UserController {
		
		@Autowired ClientService clientService;
		
		@GetMapping
		public ResponseEntity<?> getAllClients(){
			return new ResponseEntity<List<Client>>(clientService.getAllUser(), HttpStatus.OK);
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<?> getClient(@PathVariable Long id){
			return new ResponseEntity<Client>(clientService.getUser(id), HttpStatus.OK);

		}
		
		@PostMapping
		public ResponseEntity<?> createClient(@RequestBody Client client) {
			return new ResponseEntity<Client>(clientService.createClient(client), HttpStatus.CREATED);

		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<String> deleteClient(@PathVariable Long id){
			return new ResponseEntity<String>(clientService.removeClient(id), HttpStatus.OK);

		}
		
		@PutMapping("/{id}")
		public ResponseEntity<?> updateUser(@RequestBody Client client) {
			return new ResponseEntity<Client>(clientService.updateClient(client), HttpStatus.CREATED);

		}
		

	}


}

