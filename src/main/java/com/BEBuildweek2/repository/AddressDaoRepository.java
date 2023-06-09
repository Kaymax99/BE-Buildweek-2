package com.BEBuildweek2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.BEBuildweek2.model.Address;

public interface AddressDaoRepository extends CrudRepository<Address, Long>, PagingAndSortingRepository<Address, Long> {
		
	public Address findByVia(String via);
}
