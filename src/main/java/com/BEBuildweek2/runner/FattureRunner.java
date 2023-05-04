package com.BEBuildweek2.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.BEBuildweek2.model.Cliente;
import com.BEBuildweek2.model.CustomerType;
import com.BEBuildweek2.model.Fattura;
import com.BEBuildweek2.model.State;
import com.BEBuildweek2.service.ClientService;
import com.BEBuildweek2.service.FattureService;


@Component
public class FattureRunner implements ApplicationRunner {
	
	
	//@Autowired @Qualifier("FatturaBean") ObjectProvider<Fattura> fatturaBeanProvider;
	
	@Autowired FattureService fatturaService;
	@Autowired ClientService  clientService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Clients Running...");
		
		/*
		 * Fattura f = new Fattura(); f.setAnno(2023); f.setData(LocalDate.now());
		 * f.setImporto(1234567890l); f.setNumero(12l); f.setStato(State.ANNULLATA);
		 */
		
		/*
		 * Cliente c = clientService.findById(1l); Fattura f =
		 * fatturaService.findById(1l); f.setCliente(c);
		 * 
		 * 
		 * fatturaService.updateFatture(f);
		 */
		//fatturaService.createFattura(fatturaBeanProvider.getObject());
	}

}
