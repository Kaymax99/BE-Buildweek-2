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
	
//	@Query(value = "SELECT * FROM be_service_clienti c orderby c.fatturatoAnnuale ")
//	public Page<Cliente> filterByFatturato(Double f, String s);
	
//	Data_inserimento
//	Data_ultimo_contratto


	@Query(value = "SELECT * FROM be_service_clienti c ORDER BY c.nome ASC", nativeQuery = true)
	public Page<Cliente> orderByName(Pageable pageable);
	
	@Query(value = "SELECT * FROM be_service_clienti c ORDER BY c.fatturato_annuale ASC", nativeQuery = true)
	public Page<Cliente> orderByFatturato(Pageable pageable);
	
	@Query(value = "SELECT * FROM be_service_clienti c ORDER BY c.data_inserimento ASC", nativeQuery = true)
	public Page<Cliente> orderByDataIns(Pageable pageable);
	
	@Query(value = "SELECT * FROM be_service_clienti c ORDER BY c.data_ultimo_contatto ASC", nativeQuery = true)
	public Page<Cliente> orderByDataUltimo(Pageable pageable);
	
	@Query(value = "SELECT * FROM be_service_clienti c WHERE c.fatturato_annuale >= :fatturato ORDER BY c.fatturato_annuale ASC", nativeQuery = true)
	public Page<Cliente> filterByFatturatoUp(double fatturato, Pageable pageable);
	
	@Query(value = "SELECT * FROM be_service_clienti c WHERE c.fatturato_annuale <= :fatturato ORDER BY c.fatturato_annuale ASC", nativeQuery = true)
	public Page<Cliente> filterByFatturatoDown(double fatturato, Pageable pageable);
	
	@Query(value = "SELECT * FROM be_service_clienti c WHERE c.data_inserimento LIKE :data ORDER BY c.data_inserimento ASC", nativeQuery = true)
	public Page<Cliente> filterByDataIns(LocalDate data, Pageable pageable);
	
	
	Page<Cliente> findByPec(String pec, Pageable pageable);
	Iterable<Cliente> findAll(Sort sort);
	
	

}
