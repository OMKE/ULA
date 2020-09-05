package com.ula.exam.service.takingexam;

import com.ula.exam.dto.model.TakingExamDTO;
import com.ula.exam.service.exception.FinalExamNotFoundException;
import com.ula.exam.service.exception.SubjectAttendanceConflictException;
import com.ula.exam.service.exception.SubjectAttendanceNotFoundException;
import com.ula.exam.service.exception.TakingExamNotFoundException;

import java.util.List;

public interface TakingExamService
{
    List<TakingExamDTO> index();

    TakingExamDTO show(Long id) throws TakingExamNotFoundException;

    String store(TakingExamDTO takingExamDTO, String token)
    throws SubjectAttendanceNotFoundException, SubjectAttendanceConflictException;

    TakingExamDTO getWithPointsCalculated(Long id)
    throws TakingExamNotFoundException, FinalExamNotFoundException;

    String update(Long id, TakingExamDTO takingExamDTO) throws TakingExamNotFoundException;

    String delete(Long id) throws TakingExamNotFoundException;
}
