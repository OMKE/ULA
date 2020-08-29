package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.Subject;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

import java.util.List;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long>
{
    List<Subject> findAllByYearOfStudyId(Long yearOfStudyId);
}
