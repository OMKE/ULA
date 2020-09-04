package com.ula.exam.mapper;

import com.ula.exam.domain.model.TakingExam;
import com.ula.exam.dto.model.TakingExamDTO;

import java.util.List;
import java.util.stream.Collectors;

public class TakingExamMapper
{
    public static TakingExamDTO map(TakingExam takingExam)
    {
        return new TakingExamDTO()
                    .setId(takingExam.getId())
                    .setSubjectAttendanceId(takingExam.getSubjectAttendanceId())
                    .setNote(takingExam.getNote())
                    .setPoints(takingExam.getPoints());
    }

    public static List<TakingExamDTO> map(List<TakingExam> takingExams)
    {
        return takingExams.stream().map(TakingExamMapper::map).collect(Collectors.toList());
    }
}
