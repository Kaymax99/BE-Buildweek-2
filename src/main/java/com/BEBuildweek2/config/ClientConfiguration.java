package com.BEBuildweek2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


import com.BEBuildweek2.model.Client;
import com.BEBuildweek2.model.CustomerType;
import com.rest_project.model.User;

@Configuration

public class ClientConfiguration {	
	
	@Value("${user.admin.name}") private String adminName;
	@Value("${user.admin.lastname}") private String adminLastname;
	@Value("${user.admin.email}") private String adminEmail;
	@Value("${user.admin.age}") private Integer adminAge;
	@Value("${user.admin.city}") private String adminCity;
	@Value("${user.admin.password}") private String adminPassword;
	
	
	@Bean("ClientBean")
	@Scope("prototype")
	public Client newClient() {
		return Client.builder()
				.ragionesociale()
				.formasocietaria(CustomerType.PA)
				.partitaiva()
				.email()
				.datainserimento()
				.dataultimocontratto()
				.fatturatoannuale()
				.pec()
				.email()
				.telefono()
				.nome()
				.cognome()
				.build();
	}
	
	
	
	@Bean("ClientBean")
	@Scope("prototype")
	public Client newCustomClient() {
		return new Client();
	}

}
