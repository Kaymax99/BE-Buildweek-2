package com.BEBuildweek2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BEBuildweek2.model.EState;
import com.BEBuildweek2.model.State;

public interface StateRepository extends JpaRepository<State, Long>{
	
	State findByNome(EState name);

}
