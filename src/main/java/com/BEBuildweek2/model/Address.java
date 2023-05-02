package com.BEBuildweek2.model;


 
import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	private int  civico;
	private String localita;
	private Long cap;
	private String comune;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Cliente client;

}
