package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.SubjectRealization;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface SubjectRealizationRepository extends CrudRepository<SubjectRealization, Long>
{
    Optional<SubjectRealization> findBySubjectId(Long subjectId);
}
