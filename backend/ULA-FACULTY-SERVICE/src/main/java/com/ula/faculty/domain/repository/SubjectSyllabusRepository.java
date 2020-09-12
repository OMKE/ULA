package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.SubjectSyllabus;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

@Repository
public interface SubjectSyllabusRepository extends CrudRepository<SubjectSyllabus, Long>
{

}
