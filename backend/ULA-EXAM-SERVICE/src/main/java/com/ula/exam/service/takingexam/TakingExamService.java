package com.ula.exam.service.takingexam;

import com.ula.exam.api.v1.request.StoreTakingExamRequest;
import com.ula.exam.dto.model.ExamDTO;
import com.ula.exam.dto.model.TakingExamDTO;
import com.ula.exam.service.exception.*;

import java.util.List;

public interface TakingExamService
{
    List<TakingExamDTO> index();

    TakingExamDTO show(Long id) throws TakingExamNotFoundException;


    TakingExamDTO showByStudentIdAndSubjectAttendanceId(Long studentId, Long subjectAttendanceId)
    throws TakingExamNotFoundException;

    TakingExamDTO showBySubjectAttendanceId(Long subjectAttendanceId)
    throws TakingExamNotFoundException;

    String store(TakingExamDTO takingExamDTO, String token)
    throws SubjectAttendanceNotFoundException, SubjectAttendanceConflictException;

    String store(List<StoreTakingExamRequest> requests);

    String createExams(List<Long> subjectAttendanceIds, ExamDTO examDTO)
    throws TakingExamNotFoundException, ExamTypeNotFoundException, ExamTermNotFoundException;


    String update(Long id, TakingExamDTO takingExamDTO) throws TakingExamNotFoundException;

    String delete(Long id) throws TakingExamNotFoundException;
}
