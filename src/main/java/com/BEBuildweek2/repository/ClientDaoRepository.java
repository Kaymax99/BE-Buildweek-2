package com.BEBuildweek2.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.BEBuildweek2.model.Cliente;


public interface ClientDaoRepository extends CrudRepository<Cliente, Long>, PagingAndSortingRepository<Cliente, Long> {
	
	public Cliente findByEmail(String email);
	public boolean existsByEmail(String email);
	
//	@Query(value = "SELECT c FROM be_service_clienti c WHERE :fatturato = c.fatturatoAnnuale")
//	public Page<Cliente> filterByFatturato(double fatturato, Pageable pageable);
	
//	@Query(value = "SELECT c FROM be_service_clienti c orderby c.fatturatoAnnuale ")
//	public Page<Cliente> filterByFatturato(Double f, String s);
	
//	Fatturato_Annuale
//	Data_inserimento
//	Data_ultimo_contratto
//	NomeContaining
	@Query(value = "SELECT * FROM be_service_clienti c ORDER BY c.nome ASC", nativeQuery = true)
	public Page<Cliente> ascendingName(Pageable pageable);
	
	Page<Cliente> findByPec(String pec, Pageable pageable);
	Iterable<Cliente> findAll(Sort sort);
	

}
