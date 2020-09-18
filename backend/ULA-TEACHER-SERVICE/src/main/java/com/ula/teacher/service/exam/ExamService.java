package com.ula.teacher.service.exam;

import com.ula.teacher.dto.ExamDTO;
import com.ula.teacher.service.exception.SubjectAttendancesNotFoundException;
import com.ula.teacher.service.exception.TeacherNotFoundException;
import org.ula.core.api.response.Response;

public interface ExamService
{
    Response<Object> store(Long subjectId, ExamDTO examDTO)
    throws SubjectAttendancesNotFoundException, TeacherNotFoundException;
}
