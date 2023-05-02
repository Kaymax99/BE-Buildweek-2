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
import com.BEBuildweek2.service.ClientService;


@Component
public class ClientRunner implements ApplicationRunner {
	
	
	@Autowired @Qualifier("ClientBean") ObjectProvider<Cliente> clientBeanProvider;
	
	@Autowired ClientService clientService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Clients Running...");
//		
//		Cliente c = new Cliente();
//		c.setRagione_sociale("Ragione sociale");
//		c.setTipo_cliente(CustomerType.PA);
//		c.setPartita_iva(1234567890l);
//		c.setData_inserimento(LocalDate.now());
//		c.setData_ultimo_contratto(LocalDate.now());
//		c.setFatturato_annuale(1234567890d);
//		c.setPec("ABC@gmail.com");
//		c.setEmail("CDE@gmail.com");
//		c.setTelefono(1234567890l);
//		c.setNome("EGG");
//		c.setCognome("ARF");
//		
//		clientService.saveClient(c);
//		clientService.createClient(clientBeanProvider.getObject());
	}

}
