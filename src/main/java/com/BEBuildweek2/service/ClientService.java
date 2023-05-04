package com.BEBuildweek2.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.BEBuildweek2.model.Cliente;
import com.BEBuildweek2.repository.ClientDaoRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClientService {
	
	@Autowired ClientDaoRepository repo;
	
	 @Autowired @Qualifier("FakeClient") private ObjectProvider<Cliente> fakeProvider;
	
	public void saveFakeClient() {
		Cliente c = fakeProvider.getObject();
		saveClient(c);
		log.info("Fake user succesfully created!");
	}

	public Page<Cliente> findAllClienti(Pageable pageable) {
		return (Page<Cliente>) repo.findAll(pageable);
	}
	public Page<Cliente> sortAll(Sort sort) {
		return (Page<Cliente>) repo.findAll(sort);
	}
	
	public Cliente findById(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("User not exists!!!");
		}
		return repo.findById(id).get();
	}
	
	public Cliente saveClient(Cliente client) {
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
	
	public Cliente updateClient(Cliente client) {
		if(!repo.existsById(client.getId())) {
			throw new EntityExistsException("Client not exists!!!");
		}
		repo.save(client);
		return client;
	}
//	public Page<Cliente> findByFatturato_Annuale(double d, Pageable pageable){
//		return repo.findByFatturato_Annuale(d, pageable);
//	}
	
	public Page<Cliente> findByPec(String pec, Pageable pageable){
		return repo.findByPec(pec, pageable);
	}
	
//	public Page<Cliente> orderByName(Pageable pageable) {
//		return (Page<Cliente>) repo.orderByName(pageable);
//	}
	public Page<Cliente> ascendingName(Pageable pageable) {
		return repo.ascendingName(pageable);
	}
	
//	public Page<Cliente> filterByFatturato(double d, Pageable pageable) {
//		return repo.filterByFatturato(d, pageable);
//	}
}
