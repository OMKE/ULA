package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.Faculty;
import org.springframework.stereotype.Repository;


@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Long>
{

}
