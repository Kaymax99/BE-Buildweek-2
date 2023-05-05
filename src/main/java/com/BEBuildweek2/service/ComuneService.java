package com.BEBuildweek2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BEBuildweek2.model.Comune;
import com.BEBuildweek2.repository.ComuneDaoRepository;

@Service
public class ComuneService {
	
	@Autowired ComuneDaoRepository repo;
	
	public Comune getComune(String comune) {
		return repo.findByComune(comune);
	}
	

}
