package com.ula.student.service.exam;

import com.ula.student.api.v1.request.UpdateExamEntryRequest;
import com.ula.student.dto.ExamDTO;
import com.ula.student.service.exception.EntryIsAlreadyActiveException;
import com.ula.student.service.exception.ExamNotFoundException;

public interface ExamService
{
    ExamDTO show(Long subjectAttendanceId, Long examId);

    String storeEntry(Long subjectAttendanceId, Long examId, UpdateExamEntryRequest updateExamEntryRequest)
    throws EntryIsAlreadyActiveException, ExamNotFoundException;
}
