package com.BEBuildweek2.model;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;
	import lombok.AllArgsConstructor;
	import lombok.Builder;
	import lombok.Data;
	import lombok.NoArgsConstructor;

	@Entity
	@Table(name = "clienti") 
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	@Builder
	public class Client {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(nullable = false)
		private String ragionesociale;
		@Column(nullable=false)
		private CustomerType formasocietaria;
		@Column(nullable = false, unique=true)
		private Long partitaiva;
		@Column(nullable = false)
		private LocalDateTime datainserimento= LocalDateTime.now();
		@Column(nullable = false)
		private LocalDateTime dataultimocontratto;
		@Column(nullable = false)
		private Long fatturatoannuale;
		@Column(nullable = false, unique = true)
		private String pec;
		@Column(nullable = false, unique = true)
		private String email;
		@Column(nullable = false)
		private Long telefono;
		@Column(nullable = false)
		private String nome;
		@Column(nullable = false)
		private String cognome;

	}



