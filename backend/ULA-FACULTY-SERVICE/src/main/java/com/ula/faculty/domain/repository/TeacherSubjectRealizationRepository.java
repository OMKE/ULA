package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.TeacherSubjectRealization;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface TeacherSubjectRealizationRepository extends CrudRepository<TeacherSubjectRealization, Long>
{
    Optional<TeacherSubjectRealization> findBySubjectRealizationIdAndTeacherOnRealizationId(Long subjectRealizationId, Long teacherOnRealizationId);
}
