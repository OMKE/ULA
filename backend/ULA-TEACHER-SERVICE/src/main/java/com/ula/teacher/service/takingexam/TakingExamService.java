package com.ula.teacher.service.takingexam;

import com.ula.teacher.dto.TakingExamDTO;
import com.ula.teacher.api.v1.request.UpdateTakingExamRequest;
import com.ula.teacher.service.exception.SubjectAttendanceNotFoundException;
import com.ula.teacher.service.exception.TakingExamNotFoundException;
import org.ula.core.api.response.Response;

public interface TakingExamService
{


    TakingExamDTO show(Long subjectId, Long studentId)
    throws SubjectAttendanceNotFoundException;

    Response<Object> getTakingExamPointsCalculated(Long subjectId, Long studentId)
    throws SubjectAttendanceNotFoundException, TakingExamNotFoundException;

    Response<Object> update(Long subjectId, Long studentId, UpdateTakingExamRequest request)
    throws SubjectAttendanceNotFoundException, TakingExamNotFoundException;
}
