package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.SubjectAttendance;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

@Repository
public interface SubjectAttendanceRepository extends CrudRepository<SubjectAttendance, Long>
{

}
