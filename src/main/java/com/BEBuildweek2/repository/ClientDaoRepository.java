package com.BEBuildweek2.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.BEBuildweek2.model.Client;

<<<<<<< Updated upstream
public interface ClientDaoRepository extends CrudRepository<Client, Long> {
=======
public interface ClientDaoRepository extends CrudRepository<Cliente, Long>, PagingAndSortingRepository<Cliente, Long> {
>>>>>>> Stashed changes
	
	public Client findByEmail(String email);
	public boolean existsByEmail(String email);
	
	Page<Cliente> findByFatturato_annuale(double fatturato, Pageable pageable);
	Page<Cliente> findByData_inserimento(LocalDate date, Pageable pageable);
	Page<Cliente> findByData_ultimo_contratto(LocalDate date, Pageable pageable);
	Page<Cliente> findByNomeContaining(String parteDelNome, Pageable pageable);
	

}
