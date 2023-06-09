package com.BEBuildweek2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.BEBuildweek2.model.Address;
import com.BEBuildweek2.repository.AddressDaoRepository;
import com.BEBuildweek2.repository.ClientDaoRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service

public class AddressService {
	
	@Autowired AddressDaoRepository repo;
	@Autowired
	private ClientDaoRepository clientRepo;

	public Page<Address> getAllAddress(Pageable pageable) {
		return (Page<Address>) repo.findAll(pageable);
	}
	public List<Address> getAllAddressList() {
		return (List<Address>) repo.findAll();
	}
	
	public Address getAddress(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Address not exists!!!");
		}
		return repo.findById(id).get();
	}
	
	
//	public void addAddress(Cliente client, Address address) {
//	    if (client.getAddresses().size() < 2) {
//	        address.setClient(client);
//	        client.getAddresses().add(address);
//	    } else {
//	        throw new RuntimeException("Client already has two addresses");
//	    }
//	}

	
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
	public Address saveAddress(Address address) {
		repo.save(address);
		return  address;
	}


	


}
