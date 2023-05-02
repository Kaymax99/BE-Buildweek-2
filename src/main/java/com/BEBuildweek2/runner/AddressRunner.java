package com.BEBuildweek2.runner;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.BEBuildweek2.model.Address;
import com.BEBuildweek2.service.AddressService;
import com.BEBuildweek2.model.Client;
import com.BEBuildweek2.service.ClientService;


@Component
public class AddressRunner implements ApplicationRunner {
	
	
	@Autowired @Qualifier("AddressBean") ObjectProvider<Address> addressBeanProvider;
	@Autowired @Qualifier("ClientBean") ObjectProvider<Address> clientBeanProvider;
	
	@Autowired AddressService addressService;
	@Autowired ClientService clientService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Run...");
		
		addressService.addAddress(addressBeanProvider.getObject());
	}

}
