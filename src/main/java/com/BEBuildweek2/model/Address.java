package com.BEBuildweek2.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "be_service_indirizzi") 
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Address {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String via;
	private int civico;
	private String localita;
	private Long cap;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Comune comune;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Cliente client;

}
