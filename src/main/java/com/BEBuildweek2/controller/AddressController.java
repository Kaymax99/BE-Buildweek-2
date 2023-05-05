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

import com.BEBuildweek2.auth.exception.MyAPIException;
import com.BEBuildweek2.model.Address;
import com.BEBuildweek2.model.Comune;

import com.BEBuildweek2.model.Cliente;
import com.BEBuildweek2.service.AddressService;
import com.BEBuildweek2.service.ClientService;
import com.BEBuildweek2.service.ComuneService;

@RestController
@RequestMapping("/addresses")
public class AddressController {

	
	@Autowired 
	AddressService addressService;
	@Autowired
	ComuneService comuneService;
	
	@Autowired
	ClientService clienteService;
	
	@GetMapping(path = "/all")
	public ResponseEntity<?> getAllIndirizzi(Pageable pageable){
		return new ResponseEntity<>(addressService.getAllAddress(pageable), HttpStatus.OK);
	}
	
	@PostMapping(path = "/save/{comune}")
	public ResponseEntity<?> assignIndirizzo(@PathVariable(name = "comune") String comune,@RequestBody Address a) {
		Comune c = comuneService.getComune(comune);
		a.setComune(c);
		return new ResponseEntity<>(addressService.saveAddress(a), HttpStatus.CREATED);
	}
	
	@PostMapping(path= "/save/client/sede-legale/{email-client}")
	public ResponseEntity<?> assignClienteLegale(@PathVariable(name = "email-client") String cliente,@RequestBody Address a) {
		
		Cliente c = clienteService.findByEmail(cliente);
		if(c.getIndirizzoSedeLegale() != null) {
			throw new MyAPIException(HttpStatus.BAD_REQUEST, "questo cliente ha già una sede legale salvata");
		}else {	
		a.setClient(c);
		c.setIndirizzoSedeLegale(a);
		clienteService.updateClient(c);
		return new ResponseEntity<>(addressService.saveAddress(a), HttpStatus.CREATED);}

	}
	@PostMapping(path= "/save/client/sede-operativa/{email-client}")
	public ResponseEntity<?> assignClienteOperativa(@PathVariable(name = "email-client") String cliente,@RequestBody Address a) {
		
		Cliente c = clienteService.findByEmail(cliente);
		if(c.getIndirizzoSedeOperativa() != null) {
			throw new MyAPIException(HttpStatus.BAD_REQUEST, "questo cliente ha già una sede legale salvata");
		}else {	
		a.setClient(c);
		c.setIndirizzoSedeOperativa(a);
		clienteService.updateClient(c);
		return new ResponseEntity<>(addressService.saveAddress(a), HttpStatus.CREATED);}

	}
}

