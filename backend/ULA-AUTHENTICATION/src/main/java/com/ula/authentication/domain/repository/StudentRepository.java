package com.ula.authentication.domain.repository;

import com.ula.authentication.domain.model.Student;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>
{
    Optional<Student> getByUserId(Long userId);

    Optional<Student> findBySsn(String ssn);

}
