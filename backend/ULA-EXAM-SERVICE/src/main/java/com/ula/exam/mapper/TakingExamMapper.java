package com.ula.exam.mapper;

import com.ula.exam.domain.model.TakingExam;
import com.ula.exam.dto.model.ExamDTO;
import com.ula.exam.dto.model.ExamEntryDTO;
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
                    .setPoints(takingExam.getPoints())
                    .setExams
                            (
                                    takingExam.getExams()
                                          .stream()
                                          .map(exam ->
                                                   new ExamDTO()
                                                           .setId(exam.getId())
                                                            .setTakingExamId(takingExam.getId())
                                                            .setExamTypeId(exam.getType().getId())
                                                            .setExamType(exam.getType().getName())
                                                            .setStartTime(exam.getStartTime())
                                                            .setEndTime(exam.getEndTime())
                                                            .setPoints(exam.getPoints())
                                                            .setFinalExam(exam.isFinalExam())
                                                            .setExamEntry(exam.getExamEntry() != null ?
                                                                    new ExamEntryDTO()
                                                                        .setId(exam.getExamEntry().getId())
                                                                        .setExamTerm(exam.getExamEntry().getExamTerm().getName())
                                                                        .setActive(exam.getExamEntry().isActive())
                                                                        .setExamTermId(exam.getExamEntry().getExamTerm().getId())
                                                                        .setExamId(exam.getId())
                                                                        : null
                                                                         )
                                              )
                                          .collect(Collectors.toList())

                            );
    }

    public static List<TakingExamDTO> map(List<TakingExam> takingExams)
    {
        return takingExams.stream().map(TakingExamMapper::map).collect(Collectors.toList());
    }
}
