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
import com.BEBuildweek2.model.State;


public interface FatturaDaoRepository extends CrudRepository<Fattura, Long>, PagingAndSortingRepository<Fattura, Long> {
	
	
//	@Query(value = "SELECT c FROM be_service_clienti c WHERE :fatturato = c.fatturatoAnnuale")
//	public Page<Cliente> filterByFatturato(double fatturato, Pageable pageable);
	
//	@Query(value = "SELECT c FROM be_service_clienti c orderby c.fatturatoAnnuale ")
//	public Page<Cliente> filterByFatturato(Double f, String s);
	
//	Fatturato_Annuale
//	Data_inserimento
//	Data_ultimo_contratto
//	NomeContaining
	@Query(value = "SELECT * FROM be_service_fatture f ORDER BY f.numero ASC ", nativeQuery = true)
	public Page<Fattura> ascendingName(Pageable pageable);
	
	@Query(value = "SELECT * FROM be_service_fatture f WHERE f.cliente_id = :clienteId ORDER BY f.cliente_id ASC", nativeQuery = true)
	public Page<Fattura> filterByCliente(Long clienteId, Pageable pageable);
	
	@Query(value = "SELECT * FROM be_service_fatture f INNER JOIN be_service_stato_fattura s ON f.stato_id = s.id WHERE f.numero = 2", nativeQuery = true)
	public Page<Fattura> filterByStato(int stato, Pageable pageable);

	Iterable<Fattura> findAll(Sort sort);
	
	

}
