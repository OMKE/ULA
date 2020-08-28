package com.ula.authentication.domain.repository;

import com.ula.authentication.domain.model.Student;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>
{

}
