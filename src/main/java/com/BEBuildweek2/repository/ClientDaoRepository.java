package com.BEBuildweek2.repository;

import org.springframework.data.repository.CrudRepository;

import com.BEBuildweek2.model.Cliente;

public interface ClientDaoRepository extends CrudRepository<Cliente, Long> {
	
	public Cliente findByEmail(String email);
	public boolean existsByEmail(String email);

}
