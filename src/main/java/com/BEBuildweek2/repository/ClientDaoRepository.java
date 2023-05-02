package com.BEBuildweek2.repository;

import org.springframework.data.repository.CrudRepository;

import com.BEBuildweek2.model.Client;

public interface ClientDaoRepository extends CrudRepository<Client, Long> {
	
	public Client findByEmail(String email);
	public boolean existsByEmail(String email);

}
