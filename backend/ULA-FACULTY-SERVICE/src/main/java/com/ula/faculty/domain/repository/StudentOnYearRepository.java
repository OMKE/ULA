package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.StudentOnYear;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentOnYearRepository extends CrudRepository<StudentOnYear, Long>
{
    Optional<StudentOnYear> findFirstByOrderByIdDesc();
    Optional<StudentOnYear> findByStudentIdAndDeletedFalse(Long studentId);

    List<StudentOnYear> findAllByStudentIdIn(Iterable<Long> studentId);
    List<StudentOnYear> findAllByTranscriptIdentifier(String transcriptIdentifier);
}
