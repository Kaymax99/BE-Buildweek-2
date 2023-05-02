package com.BEBuildweek2.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BEBuildweek2.model.Cliente;
import com.BEBuildweek2.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
		
		@Autowired 
		ClientService clientService;
		
		@GetMapping(path = "/all")
		public ResponseEntity<?> getAllClienti(Pageable pageable){
			return new ResponseEntity<>(clientService.findAllClienti(pageable), HttpStatus.OK);
		}
		
		@GetMapping(path = "/{id}")
		public ResponseEntity<?> getClient(@PathVariable(name = "id") Long id){
			return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);

		}
		
		@PostMapping
		public ResponseEntity<?> createClient(@RequestBody Cliente client) {
			return new ResponseEntity<Cliente>(clientService.saveClient(client), HttpStatus.CREATED);

		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<String> deleteClient(@PathVariable Long id){
			return new ResponseEntity<String>(clientService.removeClient(id), HttpStatus.OK);

		}
		
		@PutMapping("/{id}")
		public ResponseEntity<?> updateUser(@RequestBody Cliente client) {
			return new ResponseEntity<Cliente>(clientService.updateClient(client), HttpStatus.CREATED);
		}

		@GetMapping(path = "/pec/{pec}")
		public ResponseEntity<?> getByPec(@PathVariable(name = "pec") String pec, Pageable pageable) {
			return new ResponseEntity<>(clientService.findByPec(pec, pageable), HttpStatus.OK);
		}
}

