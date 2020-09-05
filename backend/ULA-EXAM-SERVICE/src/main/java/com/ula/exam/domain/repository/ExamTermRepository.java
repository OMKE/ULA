package com.ula.exam.domain.repository;

import com.ula.exam.domain.model.ExamTerm;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

@Repository
public interface ExamTermRepository extends CrudRepository<ExamTerm, Long>
{

}
