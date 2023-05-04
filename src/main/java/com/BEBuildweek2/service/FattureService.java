package com.BEBuildweek2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.BEBuildweek2.model.Fattura;
import com.BEBuildweek2.repository.FatturaDaoRepository;

@Service
public class FattureService {
	@Autowired
	private FatturaDaoRepository fattRep;
	
	
	public void salvaFatture(Fattura fattura) {
		fattRep.save(fattura);
	}
	
	public Page<Fattura> trovaFattureCliente(Pageable pageable){
		return (Page<Fattura>) fattRep.findAll();
	}
}
