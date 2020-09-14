package com.ula.authentication.domain.repository;

import com.ula.authentication.domain.model.Teacher;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long>
{
    Optional<Teacher> findByUserIdAndDeletedFalse(Long userId);
}
