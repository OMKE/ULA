package com.ula.research.domain.repository;

import com.ula.research.domain.model.Research;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

import java.util.List;

@Repository
public interface ResearchRepository extends CrudRepository<Research, Long>
{
    List<Research> findAllByDeletedFalseOrderByPublicationDateDesc(Pageable pageable);
}
