package com.ula.faculty.service.teacher;

import com.ula.faculty.dto.model.StudentDTO;
import com.ula.faculty.dto.model.SubjectWithRealizationIdDTO;
import com.ula.faculty.service.exception.SubjectNotFoundException;
import com.ula.faculty.service.exception.SubjectRealizationNotFoundException;
import com.ula.faculty.service.exception.TeacherOnRealizationNotFoundException;
import com.ula.faculty.service.exception.TeacherSubjectRealizationNotFoundException;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TeacherService
{
    List<SubjectWithRealizationIdDTO> subjects(Long teacherId)
    throws TeacherOnRealizationNotFoundException;
    SubjectWithRealizationIdDTO subject(Long teacherId, Long subjectId)
    throws SubjectNotFoundException, TeacherOnRealizationNotFoundException, TeacherSubjectRealizationNotFoundException;

}
