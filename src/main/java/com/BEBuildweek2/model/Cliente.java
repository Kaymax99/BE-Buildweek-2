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
import jakarta.persistence.PrimaryKeyJoinColumn;
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
		private String cognome;
		private LocalDate dataInserimento;
		private LocalDate dataUltimoContatto;
		private String email;
	    private String emailContatto;
	    private Double fatturatoAnnuale;
	    private String nome;
	    private String partitaIva;
	    private String pec;
	    private String ragioneSociale;
	    private String telefono;
	    private String telefonoContatto;
	    @Enumerated(EnumType.STRING)
	    private CustomerType tipoCliente;
	    @OneToOne(cascade = CascadeType.ALL)
	    private Address indirizzoSedeLegale;
	    @OneToOne(cascade = CascadeType.ALL)
	    private Address indirizzoSedeOperativa;
	}



