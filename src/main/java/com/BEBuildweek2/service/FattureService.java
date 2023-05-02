package com.BEBuildweek2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BEBuildweek2.model.Fattura;
import com.BEBuildweek2.repository.FattureRepository;
import com.BEBuildweek2.repository.FattureRepository;

@Service
public class FattureService {
	@Autowired
	private FattureRepository fattRep;
	
	
	public void salvaFatture(Fattura fattura) {
		fattRep.save(fattura);
	}
	
	public List<Fattura> trovaFattureCliente(Long id){
		return fattRep.findAll();
	}
}
