package com.ula.exam.service.points;

import com.ula.exam.dto.model.PointsDTO;
import com.ula.exam.service.exception.FinalExamNotFoundException;
import com.ula.exam.service.exception.TakingExamNotFoundException;

public interface PointsService
{
    PointsDTO getByTakingExamId(Long takingExamId)
    throws FinalExamNotFoundException, TakingExamNotFoundException;

    PointsDTO getBySubjectAttendanceId(Long subjectAttendanceId)
    throws TakingExamNotFoundException, FinalExamNotFoundException;
}
