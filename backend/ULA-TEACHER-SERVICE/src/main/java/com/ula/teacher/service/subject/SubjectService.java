package com.ula.teacher.service.subject;

import com.ula.teacher.api.v1.request.UpdateSubjectAttendanceFinalGradeRequest;
import com.ula.teacher.dto.SubjectWithRealizationIdDTO;
import com.ula.teacher.service.exception.StudentOnYearNotFoundException;
import com.ula.teacher.service.exception.SubjectWithRealizationIdNotFoundException;
import com.ula.teacher.service.exception.TeacherNotFoundException;
import org.ula.core.api.response.Response;

import java.util.List;

public interface SubjectService
{
    List<SubjectWithRealizationIdDTO> index();

    SubjectWithRealizationIdDTO show(Long id)
    throws SubjectWithRealizationIdNotFoundException, TeacherNotFoundException;

    Response<Object> updateFinalGrade(Long subjectId, Long studentId, UpdateSubjectAttendanceFinalGradeRequest request)
    throws StudentOnYearNotFoundException, TeacherNotFoundException;
}
