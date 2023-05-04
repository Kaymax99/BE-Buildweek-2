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
import com.BEBuildweek2.model.Fattura;


public interface FatturaDaoRepository extends CrudRepository<Fattura, Long>, PagingAndSortingRepository<Fattura, Long> {
	
	
//	@Query(value = "SELECT c FROM be_service_clienti c WHERE :fatturato = c.fatturatoAnnuale")
//	public Page<Cliente> filterByFatturato(double fatturato, Pageable pageable);
	
//	@Query(value = "SELECT c FROM be_service_clienti c orderby c.fatturatoAnnuale ")
//	public Page<Cliente> filterByFatturato(Double f, String s);
	
//	Fatturato_Annuale
//	Data_inserimento
//	Data_ultimo_contratto
//	NomeContaining
	@Query(value = "SELECT c FROM be_service_fatture c ORDER BY c.numero ASC", nativeQuery = true)
	public Page<Fattura> ascendingName(Pageable pageable);

	Iterable<Fattura> findAll(Sort sort);
	

}
