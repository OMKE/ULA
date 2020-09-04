package com.ula.exam.domain.repository;

import com.ula.exam.domain.model.ExamOutcome;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

@Repository
public interface ExamOutcomeRepository extends CrudRepository<ExamOutcome, Long>
{

}
