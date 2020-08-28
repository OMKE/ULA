package com.ula.authentication.domain.repository;

import com.ula.authentication.domain.model.Teacher;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long>
{

}
