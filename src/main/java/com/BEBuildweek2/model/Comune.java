package com.BEBuildweek2.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "be_service_comuni")
public class Comune {
	
	private String nome;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Provincia provincia;

}
