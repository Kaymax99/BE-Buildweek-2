package com.BEBuildweek2.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "be_service_comuni")
public class Comune {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String codiceprovincia;
	
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private String progressivodelcomune;
	
	private String comune;
	
	private String provincia;
	
}
