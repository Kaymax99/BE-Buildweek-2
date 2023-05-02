package com.BEBuildweek2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BEBuildweek2.model.Address;
import com.BEBuildweek2.model.Client;
import com.BEBuildweek2.repository.AddressDaoRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service

public class AddressService {
	
	@Autowired AddressDaoRepository repo;

	public List<Address> getAllAddress() {
		return (List<Address>) repo.findAll();
	}
	
	public Address getAddress(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Address not exists!!!");
		}
		return repo.findById(id).get();
	}
	
	
	public void addAddress(Client client, Address address) {
	    if (client.getAddresses().size() < 2) {
	        address.setClient(client);
	        client.getAddresses().add(address);
	    } else {
	        throw new RuntimeException("Client already has two addresses");
	    }
	}

	
	public String removeAddress(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Address not exists!!!");
		}
		repo.deleteById(id);
		return "Client Deleted!!!";
	}
	
	public Address updateAddress(Address address) {
		if(!repo.existsById(address.getId())) {
			throw new EntityExistsException("Address not exists!!!");
		}
		repo.save(address);
		return  address;
	}


}
