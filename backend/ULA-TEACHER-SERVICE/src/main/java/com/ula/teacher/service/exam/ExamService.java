package com.ula.teacher.service.exam;

import com.ula.teacher.dto.ExamDTO;
import com.ula.teacher.api.v1.request.UpdateExamRequest;
import com.ula.teacher.dto.TakingExamDTO;
import com.ula.teacher.service.exception.*;
import org.ula.core.api.response.Response;

public interface ExamService
{
    Response<Object> store(Long subjectId, ExamDTO examDTO)
    throws SubjectAttendancesNotFoundException, TeacherNotFoundException;

    ExamDTO show(Long subjectId, Long studentId, Long examId)
    throws SubjectAttendanceNotFoundException, ExamNotFoundException, TakingExamNotFoundException;

    Response<Object> update(Long subjectId, Long studentId, Long examId, UpdateExamRequest request)
    throws SubjectAttendanceNotFoundException, ExamNotFoundException;

    ExamDTO getExam(Long id, TakingExamDTO takingExamDTO);


}
