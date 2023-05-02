package com.BEBuildweek2.repository;

import org.springframework.data.repository.CrudRepository;

import com.BEBuildweek2.model.Address;

public interface AddressDaoRepository extends CrudRepository<Address, Long> {
	
	

}
