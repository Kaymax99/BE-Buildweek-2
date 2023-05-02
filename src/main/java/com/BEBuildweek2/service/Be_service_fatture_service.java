package com.BEBuildweek2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BEBuildweek2.model.Be_service_fatture_model;
import com.BEBuildweek2.repository.Be_service_fatture_repository;
import com.BEBuildweek2.repository.Be_service_fatture_repository;

@Service
public class Be_service_fatture_service {
	@Autowired
	private Be_service_fatture_repository be_service_fatture_repository;
	
	
	public void salvaFatture(Be_service_fatture_model be_service_fatture_model) {
		be_service_fatture_repository.save(be_service_fatture_model);
	}
	
	public List<Be_service_fatture_model> trovaFattureCliente(Long id){
		return be_service_fatture_repository.findAll();
	}
}
