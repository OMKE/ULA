package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.TeachingTerm;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

import java.util.List;

@Repository
public interface TeachingTermRepository extends CrudRepository<TeachingTerm, Long>
{
    List<TeachingTerm> findBySubjectRealizationId(Long subjectRealizationId);
}
