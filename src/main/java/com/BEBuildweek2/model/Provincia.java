package com.BEBuildweek2.model;

import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "be_service_province")
public class Provincia {
	
	private String nome;
	private String sigla;

}
