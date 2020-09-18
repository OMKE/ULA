package com.ula.teacher.service.student;

import com.ula.teacher.dto.StudentDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService
{
    List<StudentDTO> getStudentsBySubjectId(Long subjectId, Pageable pageable);
}
