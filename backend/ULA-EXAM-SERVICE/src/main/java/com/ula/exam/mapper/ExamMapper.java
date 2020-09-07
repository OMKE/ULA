package com.ula.exam.mapper;

import com.ula.exam.domain.model.Exam;
import com.ula.exam.dto.model.ExamDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ExamMapper
{
    public static ExamDTO map(Exam exam)
    {
        return new ExamDTO()
                    .setId(exam.getId())
                    .setTakingExamId(exam.getTakingExam().getId())
                    .setExamTypeId(exam.getType().getId())
                    .setExamType(exam.getType().getName())
                    .setStartTime(exam.getStartTime())
                    .setEndTime(exam.getEndTime())
                    .setPoints(exam.getPoints())
                    .setFinalExam(exam.isFinalExam());
    }

    public static List<ExamDTO> map(List<Exam> exams)
    {
        return exams.stream().map(ExamMapper::map).collect(Collectors.toList());
    }
}
