package com.BEBuildweek2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.BEBuildweek2.model.Comune;

public interface ComuneDaoRepository extends CrudRepository<Comune, Long>,PagingAndSortingRepository<Comune, Long>{

	public Comune findByComune(String comune);
}
