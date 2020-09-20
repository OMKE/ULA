package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.Faculty;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Long>
{
    Optional<Faculty> findBySlug(String slug);
}
