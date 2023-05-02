package com.BEBuildweek2.model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
		
		private String cognome_contatto;
		private LocalDate data_inserimento;
		private LocalDate data_ultimo_contatto;
		private String email;
	    private String email_contatto;
	    private Double fatturato_annuale;
	    private String nome_contatto;
	    private String partita_iva;
	    private String pec;
	    private String ragione_sociale;
	    private String telefono;
	    private String telefono_contatto;
	    
	    @Enumerated(EnumType.STRING)
	    private CustomerType tipo_cliente;
	    
	    @OneToOne
	    private Address indirizzo_sede_legale;
	    @OneToOne
	    private Address indirizzo_sede_operativa;

	}



