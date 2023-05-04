package com.BEBuildweek2.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.BEBuildweek2.model.Fattura;
import com.BEBuildweek2.service.FattureService;

@RestController
@RequestMapping("/fatture")
public class FatturaController {
		
		@Autowired 
		FattureService fatturaService;
		
		@GetMapping(path = "/all")
		public ResponseEntity<?> getAllFatture(Pageable pageable){
			return new ResponseEntity<>(fatturaService.trovaFattureCliente(pageable), HttpStatus.OK);
		}
		
//		@GetMapping(path = "/{id}")
//		public ResponseEntity<?> getClient(@PathVariable(name = "id") Long id){
//			return new ResponseEntity<>(fatturaService.findById(id), HttpStatus.OK);
//		}
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

