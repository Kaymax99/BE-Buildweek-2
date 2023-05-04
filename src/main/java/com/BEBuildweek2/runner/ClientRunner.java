package com.BEBuildweek2.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import com.BEBuildweek2.model.Fattura;
import com.BEBuildweek2.model.Cliente;
import com.BEBuildweek2.model.CustomerType;
import com.BEBuildweek2.service.ClientService;
import com.BEBuildweek2.service.FattureService;


@Component
public class ClientRunner implements ApplicationRunner {
	
	
//	@Autowired @Qualifier("FatturaBean1") ObjectProvider<Cliente> clientBeanProvider;
	
	@Autowired ClientService clientService;
	@Autowired FattureService fatturaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Clients Running...");
	
		Cliente c = new Cliente();
		c.setRagioneSociale("Ragione sociale");
		c.setTipoCliente(CustomerType.PA);
		c.setPartitaIva("1234567890");
		c.setDataInserimento(LocalDate.now());
		c.setDataUltimoContatto(LocalDate.now());
		c.setFatturatoAnnuale(1234567890d);
		c.setPec("ABC@gmail.com");
		c.setEmail("CDG@gmail.com");
		c.setTelefono("1234567890l");
		c.setNome("EGG");
		c.setCognome("ARF");
		

		
		
//		clientService.saveClient(c);
//		clientService.saveClient(clientBeanProvider.getObject());
	}

}
