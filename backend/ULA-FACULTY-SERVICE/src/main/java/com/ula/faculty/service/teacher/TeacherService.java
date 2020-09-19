package com.ula.faculty.service.teacher;

import com.ula.faculty.dto.model.StudentOnYearDTO;
import com.ula.faculty.dto.model.SubjectWithRealizationIdDTO;
import com.ula.faculty.service.exception.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TeacherService
{
    List<SubjectWithRealizationIdDTO> subjects(Long teacherId)
    throws TeacherOnRealizationNotFoundException;


    SubjectWithRealizationIdDTO subject(Long teacherId, Long subjectId)
    throws SubjectNotFoundException, TeacherOnRealizationNotFoundException, TeacherSubjectRealizationNotFoundException;

    List<StudentOnYearDTO> students(Long teacherId, Pageable pageable)
    throws TeacherOnRealizationNotFoundException;

    List<StudentOnYearDTO> studentsBySubject(Long subjectId, Pageable pageable)
    throws SubjectRealizationNotFoundException;

}
