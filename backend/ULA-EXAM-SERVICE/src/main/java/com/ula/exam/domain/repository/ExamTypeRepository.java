package com.ula.exam.domain.repository;

import com.ula.exam.domain.model.ExamType;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

@Repository
public interface ExamTypeRepository extends CrudRepository<ExamType, Long>
{

}
