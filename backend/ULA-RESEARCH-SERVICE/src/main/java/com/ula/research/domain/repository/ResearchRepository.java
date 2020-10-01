package com.ula.research.domain.repository;

import com.ula.research.domain.model.Research;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

@Repository
public interface ResearchRepository extends CrudRepository<Research, Long>
{

}
