package com.BEBuildweek2.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BEBuildweek2.model.Cliente;
import com.BEBuildweek2.model.Fattura;
import com.BEBuildweek2.model.State;
import com.BEBuildweek2.service.ClientService;
import com.BEBuildweek2.service.FattureService;

@RestController
@RequestMapping("/fatture")
public class FatturaController {
		
		@Autowired 
		FattureService fatturaService;
		@Autowired 
		ClientService clientService;
		
		@GetMapping(path = "/all")
		public ResponseEntity<?> getAllFatture(Pageable pageable){
			return new ResponseEntity<>(fatturaService.trovaFattureCliente(pageable), HttpStatus.OK);
		}
		
		@PostMapping(path = "/{id}")
		public ResponseEntity<?> assignCliente(@PathVariable(name = "id") Long id, @RequestBody Fattura f ){
			Cliente c = clientService.findById(id);
			f.setCliente(c);
			return new ResponseEntity<>(fatturaService.salvaFatture(f), HttpStatus.CREATED);
		}
		@GetMapping(path = "/ascending")
		public ResponseEntity<?> getAllFattureAscending(Pageable pageable){
			return new ResponseEntity<>(fatturaService.ascendingFatture(pageable), HttpStatus.OK);
		}
		
		@GetMapping(path = "/filter/id/{clienteId}")
		public ResponseEntity<?> filterByCliente(@PathVariable(name = "clienteId") Long clienteId, Pageable pageable) {
			return new ResponseEntity<>(fatturaService.filterByCliente(clienteId, pageable), HttpStatus.OK);
		}
		
		@GetMapping(path = "/filter/state/{stato}")
		public ResponseEntity<?> filterByStato(@PathVariable(name = "stato") int stato, Pageable pageable) {
			return new ResponseEntity<>(fatturaService.filterByStato(stato, pageable), HttpStatus.OK);
		}
//		
//		@PostMapping
//		public ResponseEntity<?> createClient(@RequestBody Fattura fattura) {
//			return new ResponseEntity<Cliente>(fatturaService.saveClient(client), HttpStatus.CREATED);
//
//		}
//		
//		@DeleteMapping("/{id}")
//		public ResponseEntity<String> deleteClient(@PathVariable Long id){
//			return new ResponseEntity<String>(fatturaService.removeClient(id), HttpStatus.OK);
//
//		}
//		
//		@PutMapping("/{id}")
//		public ResponseEntity<?> updateUser(@RequestBody Fattura fattura) {
//			return new ResponseEntity<Cliente>(fatturaService.updateClient(client), HttpStatus.CREATED);
//		}
//
//		@GetMapping(path = "/pec/{pec}")
//		public ResponseEntity<?> getByPec(@PathVariable(name = "pec") String pec, Pageable pageable) {
//			return new ResponseEntity<>(fatturaService.findByPec(pec, pageable), HttpStatus.OK);
//		}
//		
////		@GetMapping(path = "/all")
////		public ResponseEntity<?> orderByName(Pageable pageable){
////			return new ResponseEntity<>(clientService.findAllClienti(pageable), HttpStatus.OK);
////		}
//		@GetMapping(path = "/nome")
//		public ResponseEntity<?> ascendingName(Pageable pageable) {
//			return new ResponseEntity<>(fatturaService.ascendingName(pageable), HttpStatus.OK);
//		}
//		
////		@GetMapping(path = "/fatturato/{fatturato}")
////		public ResponseEntity<?> filterByFatturato()
}

