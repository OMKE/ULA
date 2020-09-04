package com.ula.exam.mapper;

import com.ula.exam.domain.model.ExamOutcome;
import com.ula.exam.dto.model.ExamOutcomeDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ExamOutcomeMapper
{
    public static ExamOutcomeDTO map(ExamOutcome examOutcome)
    {
        return new ExamOutcomeDTO()
                    .setId(examOutcome.getId())
                    .setExamId(examOutcome.getExam().getId())
                    .setDescription(examOutcome.getDescription());
    }

    public static List<ExamOutcomeDTO> map(List<ExamOutcome> examOutcomes)
    {
        return examOutcomes.stream().map(ExamOutcomeMapper::map).collect(Collectors.toList());
    }

}
