package com.BEBuildweek2.runner;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.BEBuildweek2.model.Cliente;
import com.BEBuildweek2.model.CustomerType;
import com.BEBuildweek2.model.EState;
import com.BEBuildweek2.model.Fattura;
import com.BEBuildweek2.model.State;
import com.BEBuildweek2.repository.StateRepository;
import com.BEBuildweek2.service.ClientService;
import com.BEBuildweek2.service.FattureService;

import lombok.extern.slf4j.Slf4j;


@Component
public class FattureRunner implements ApplicationRunner {
	
	
	//@Autowired @Qualifier("FatturaBean") ObjectProvider<Fattura> fatturaBeanProvider;
	
	@Autowired FattureService fatturaService;
	@Autowired ClientService clientService;
	@Autowired StateRepository stateService;
	
	private Set<State> states;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Fatture Running...");
		
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
		// fatturaService.createFattura(fatturaBeanProvider.getObject());
		// setStatoFattureDefault();
	}
	
	private void setStatoFattureDefault() {
		State check1 = stateService.findByNome(EState.PAGATA);
		if (check1 == null) {
			State pagata = new State();
			pagata.setNome(EState.PAGATA);
			stateService.save(pagata);
		}
		
		State check2 = stateService.findByNome(EState.ATTESA_PAGAMENTO);
		if (check2 == null) {
			State inAttesa = new State();
			inAttesa.setNome(EState.ATTESA_PAGAMENTO);
			stateService.save(inAttesa);
		}
		
		State check3 = stateService.findByNome(EState.ANNULLATA);
		if (check3 == null) {
			State annullata = new State();
			annullata.setNome(EState.ANNULLATA);
			stateService.save(annullata);
		}
		
		State check4 = stateService.findByNome(EState.SCADUTA);
		if (check4 == null) {
			State scaduta = new State();
			scaduta.setNome(EState.SCADUTA);
			stateService.save(scaduta);
		}
	}
}
