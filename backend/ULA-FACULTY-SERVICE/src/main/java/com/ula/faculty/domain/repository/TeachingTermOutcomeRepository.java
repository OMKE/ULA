package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.TeachingTermOutcome;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

@Repository
public interface TeachingTermOutcomeRepository extends CrudRepository<TeachingTermOutcome, Long>
{

}
