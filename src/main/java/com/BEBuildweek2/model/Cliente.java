package com.BEBuildweek2.model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Entity
	@Table(name = "be_service_clienti") 
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	@Builder
	public class Cliente {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private String ragione_sociale;
	
		private CustomerType tipo_cliente;

		private Long partita_iva;

		private LocalDate data_inserimento;
		
		private LocalDate data_ultimo_contratto;

		private Long fatturato_annuale;

		private String pec;

		private String email;

		private Long telefono;
	
		private String nome;
	
		private String cognome;
		@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
		private List<Address> addresses = new ArrayList<>();

	}



