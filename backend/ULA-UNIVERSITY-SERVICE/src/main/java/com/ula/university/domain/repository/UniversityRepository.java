package com.ula.university.domain.repository;

import com.ula.university.domain.model.University;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UniversityRepository extends CrudRepository<University, Long>
{
    Optional<University> findByName(String name);
}
