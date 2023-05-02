package com.BEBuildweek2.model;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "be_service_indirizzi")
public class Indirizzo {
	
	private String via;
	
	private int civico;
	
	private String localita;
	
	private int cap;
	
	@OneToOne
	private Comune comune;

}
