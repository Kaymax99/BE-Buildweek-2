package com.BEBuildweek2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


import com.BEBuildweek2.model.Client;

@Configuration

public class ClientConfiguration {	
	@Bean("ClientBean")
	@Scope("prototype")
	public Client newCustomClient() {
		return new Client();
	}

}
