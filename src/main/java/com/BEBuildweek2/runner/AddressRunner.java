package com.BEBuildweek2.runner;

import java.util.ArrayList;

import org.aspectj.weaver.reflect.Java14GenericSignatureInformationProvider;
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
//		updateAllAddress();
	}

	public void updateAllAddress() {

		ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
		listaClienti = (ArrayList<Cliente>) clientService.findAllClientiList();

		
		Cliente c;
		Address a;
		Address a1;
		for (int i = 0; i<listaClienti.size(); i++) {
			c = listaClienti.get(i);
			a = c.getIndirizzoSedeLegale();
			a1 = c.getIndirizzoSedeOperativa();
			if (a != null) {
				a.setClient(c);
				addressService.updateAddress(a);
			}
			if (a != null) {
				a1.setClient(c);
				addressService.updateAddress(a1);
			}
		}
	}
}
