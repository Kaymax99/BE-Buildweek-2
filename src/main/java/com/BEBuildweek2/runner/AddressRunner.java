package com.BEBuildweek2.runner;

import java.util.ArrayList;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.BEBuildweek2.model.Address;
import com.BEBuildweek2.service.AddressService;
import com.BEBuildweek2.model.Cliente;
import com.BEBuildweek2.service.ClientService;

@Component
public class AddressRunner implements ApplicationRunner {

	@Autowired
	@Qualifier("AddressBean")
	ObjectProvider<Address> addressBeanProvider;
	@Autowired
	@Qualifier("ClientBean")
	ObjectProvider<Address> clientBeanProvider;

	@Autowired
	AddressService addressService;
	@Autowired
	ClientService clientService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Address Running...");
		updateAllAddress();
//		addressService.addAddress(addressBeanProvider.getObject());
	}

	public void updateAllAddress() {

		ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
		listaClienti = (ArrayList<Cliente>) clientService.findAllClientiList();

		
		for (int i=0; i<listaClienti.size(); i++) {
			Cliente c = listaClienti.get(i);
			Address a = c.getIndirizzoSedeLegale();
			a.setClient(c);
			addressService.updateAddress(a); 
		}

//		for (Cliente c1 : listaClienti) {
//			if (c != null) {
//
//				
//				  Address a2 = c.getIndirizzoSedeOperativa(); a1.setClient(c); a2.setClient(c);
//				  addressService.updateAddress(a1); addressService.updateAddress(a2);
//				 
//			}

//		}
	}

}
