package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.SubjectAttendance;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectAttendanceRepository extends CrudRepository<SubjectAttendance, Long>
{
    List<SubjectAttendance> getAllByStudentId(Long studentId);
    List<SubjectAttendance> getAllByStudentIdAndFinalGradeNotNull(Long studentId);
    List<SubjectAttendance> getAllByStudentIdAndFinalGradeNull(Long studentId);

    Optional<SubjectAttendance> getByIdAndStudentIdAndDeletedFalse(Long id, Long studentId);

    List<SubjectAttendance> getAllBySubjectRealizationIdAndStudentIdAndDeletedFalse(Long subjectRealizationId, Long studentId);
}
