package com.BEBuildweek2.config;

import java.time.LocalDate;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


import com.BEBuildweek2.model.Client;
import com.BEBuildweek2.model.CustomerType;
import com.github.javafaker.Faker;

@Configuration

public class ClientConfiguration {	
	
	
	@Bean("ClientBean")
	@Scope("prototype")
	public Client newClient() {
		Faker fake = Faker.instance(new Locale("it-IT"));

		return Client.builder()
				.ragione_sociale("Ragione sociale")
				.tipo_cliente(CustomerType.PA)
				.partita_iva(1234567890l)
				.data_inserimento(LocalDate.now())
				.data_ultimo_contratto(LocalDate.now())
				.fatturato_annuale(1234567890l)
				.pec(fake.internet().emailAddress())
				.email(fake.internet().emailAddress())
				.telefono(1234567890l)
				.nome(fake.name().firstName())
				.cognome(fake.name().lastName())
				.build();
	}
	
	
	
	@Bean("ClientBean")
	@Scope("prototype")
	public Client newCustomClient() {
		return new Client();
	}

}
