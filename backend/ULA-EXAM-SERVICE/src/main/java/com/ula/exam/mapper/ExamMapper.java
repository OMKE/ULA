package com.ula.exam.mapper;

import com.ula.exam.domain.model.Exam;
import com.ula.exam.dto.model.ExamDTO;
import com.ula.exam.dto.model.ExamEntryDTO;
import com.ula.exam.dto.model.ExamOutcomeDTO;

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
                    .setExamEntry(
                            new ExamEntryDTO()
                                .setId(exam.getExamEntry().getId())
                                .setExamTerm(exam.getExamEntry().getExamTerm().getName())
                                .setExamId(exam.getId())
                                .setExamTermId(exam.getExamEntry().getExamTerm().getId())
                                .setActive(exam.getExamEntry().isActive())
                                 )
                    .setOutcome(
                            new ExamOutcomeDTO()
                                .setId(exam.getExamOutcome().getId())
                                .setExamId(exam.getId())
                                .setDescription(exam.getExamOutcome().getDescription())
                               )
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
