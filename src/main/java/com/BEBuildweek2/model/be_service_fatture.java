package com.BEBuildweek2.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table
public class be_service_fatture implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_fattura")
	private long id;
	@Column(nullable = false)
	private int anno;
	@Column(nullable = false)
	private Date data;
	@Column(nullable = false)
	private double importo;
	@Column(nullable = false)
	private long numero;
	
	
	
}
