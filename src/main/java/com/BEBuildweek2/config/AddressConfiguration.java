package com.BEBuildweek2.config;

import java.time.LocalDate;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.BEBuildweek2.model.Address;
import com.BEBuildweek2.model.Cliente;
import com.BEBuildweek2.model.CustomerType;
import com.github.javafaker.Faker;

@Configuration

public class AddressConfiguration {	
	
	
	@Bean("FakeAddressBean")
	@Scope("prototype")
	public Address newClient() {
		Faker fake = Faker.instance(new Locale("it-IT"));

		return Address.builder()
				.via("Ragione sociale")
				.civico(12)
				.localita("narnia")
				.cap(00000l)/*
							 * .comune("Saga")
							 */
				.build();
	}
	
	
	
	@Bean("AddressBean")
	@Scope("prototype")
	public Address newCustomAddress() {
		return new Address();
	}

}
