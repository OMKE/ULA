package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.TeacherOnRealization;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface TeacherOnRealizationRepository extends CrudRepository<TeacherOnRealization, Long>
{
    // teacherId is from AuthService Teacher
    Optional<TeacherOnRealization> findByTeacherId(Long teacherId);
}
