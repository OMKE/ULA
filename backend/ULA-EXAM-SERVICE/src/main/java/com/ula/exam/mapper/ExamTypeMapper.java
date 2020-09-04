package com.ula.exam.mapper;

import com.ula.exam.domain.model.ExamType;
import com.ula.exam.dto.model.ExamTypeDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ExamTypeMapper
{
    public static ExamTypeDTO map(ExamType examType)
    {
        return new ExamTypeDTO()
                    .setId(examType.getId())
                    .setName(examType.getName());
    }

    public static List<ExamTypeDTO> map(List<ExamType> examTypes)
    {
        return examTypes.stream().map(ExamTypeMapper::map).collect(Collectors.toList());
    }
}

