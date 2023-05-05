package com.BEBuildweek2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "be_service_stato_fattura")
public class State {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idState;
    
    @Enumerated(EnumType.STRING)
	private EState nome;

}
