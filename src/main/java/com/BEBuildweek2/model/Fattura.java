package com.BEBuildweek2.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "be_service_fatture")
public class Fattura implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "be_service_clienti_fatture",
    joinColumns = @JoinColumn(name = "cliente_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "fattura_id", referencedColumnName = "id"))
	private Cliente clienti;

	private int anno;
	private LocalDate data;
	private double importo;
	private long numero;
	private State stato;
	
	
	
}
