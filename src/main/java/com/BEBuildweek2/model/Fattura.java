package com.BEBuildweek2.model;

import java.io.Serializable;
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
	private long idFattura;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Cliente cliente;

	private int anno;
	private LocalDate data;
	private double importo;
	private long numero;
	
	@JoinTable(name = "be_service_stato_fattura",
            joinColumns = @JoinColumn(name = "stato_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "nome", referencedColumnName = "id")
    )
	private EState statoId;
}
