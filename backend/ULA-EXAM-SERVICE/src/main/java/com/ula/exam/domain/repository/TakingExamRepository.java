package com.ula.exam.domain.repository;

import com.ula.exam.domain.model.TakingExam;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TakingExamRepository extends CrudRepository<TakingExam, Long>
{
    Optional<TakingExam> getBySubjectAttendanceId(Long subjectAttendanceId);

    List<TakingExam> findAllBySubjectAttendanceIdIn(Iterable<Long> subjectAttendanceIds);
}
