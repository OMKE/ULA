package com.ula.student.service.exam;

import com.ula.student.dto.ExamDTO;

public interface ExamService
{
    ExamDTO show(Long subjectAttendanceId, Long examId);
}
