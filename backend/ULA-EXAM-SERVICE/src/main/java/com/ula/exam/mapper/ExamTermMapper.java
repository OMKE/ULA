package com.ula.exam.mapper;

import com.ula.exam.domain.model.ExamTerm;
import com.ula.exam.dto.model.ExamTermDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ExamTermMapper
{
    public static ExamTermDTO map(ExamTerm examTerm)
    {
        return new ExamTermDTO()
                    .setId(examTerm.getId())
                    .setName(examTerm.getName())
                    .setStartDate(examTerm.getStartDate())
                    .setEndDate(examTerm.getEndDate());
    }

    public static List<ExamTermDTO> map(List<ExamTerm> examTerms)
    {
        return examTerms.stream().map(ExamTermMapper::map).collect(Collectors.toList());
    }
}
