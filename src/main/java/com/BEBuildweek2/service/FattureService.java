package com.BEBuildweek2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.BEBuildweek2.model.Cliente;
import com.BEBuildweek2.model.Fattura;
import com.BEBuildweek2.repository.ClientDaoRepository;
import com.BEBuildweek2.repository.FatturaDaoRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FattureService {
	@Autowired
	private FatturaDaoRepository fattRep;
	@Autowired
	private ClientDaoRepository clientRepo;
	
	
	public Fattura salvaFatture(Fattura fattura) {
		fattRep.save(fattura);
		return fattura;
	}
	public Page<Fattura> ascendingFatture(Pageable pageable){
		return (Page<Fattura>) fattRep.ascendingName(pageable);
	}
	public Page<Fattura> trovaFattureCliente(Pageable pageable){
		return (Page<Fattura>) fattRep.findAll(pageable);
	}
	public Fattura updateFatture(Fattura fattura) {
		if(!fattRep.existsById(fattura.getIdFattura())) {
			throw new EntityExistsException("Fattura not exists!!!");
		}
		fattRep.save(fattura);
		return fattura;
	}
	public Fattura findById(Long id) {
		if(!fattRep.existsById(id)) {
			throw new EntityNotFoundException("Fattura not exists!!!");
		}
		return fattRep.findById(id).get();
	}
}
