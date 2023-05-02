package com.BEBuildweek2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BEBuildweek2.model.Client;
import com.BEBuildweek2.repository.ClientDaoRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service

public class ClientService {
	
	@Autowired ClientDaoRepository repo;

	public List<Client> getAllUser() {
		return (List<Client>) repo.findAll();
	}
	
	public Client getUser(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("User not exists!!!");
		}
		return repo.findById(id).get();
	}
	
	public Client createClient(Client client) {
		if(repo.existsByEmail(client.getEmail())) {
			throw new EntityExistsException("Email exists!!!");
		} else {
			repo.save(client);
		}
		return client;
	}
	
	public String removeClient(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Client not exists!!!");
		}
		repo.deleteById(id);
		return "Client Deleted!!!";
	}
	
	public Client updateClient(Client client) {
		if(!repo.existsById(client.getId())) {
			throw new EntityExistsException("Client not exists!!!");
		}
		repo.save(client);
		return client;
	}


}
