package com.ula.faculty.mapper;

import com.ula.faculty.domain.model.SubjectRealization;
import com.ula.faculty.dto.model.SubjectRealizationDTO;

import java.util.List;
import java.util.stream.Collectors;

public class SubjectRealizationMapper
{
    public static SubjectRealizationDTO map(SubjectRealization subjectRealization)
    {
        return new SubjectRealizationDTO()
                    .setId(subjectRealization.getId())
                    .setSubjectId(subjectRealization.getSubject().getId())
                    .setDeleted(subjectRealization.isDeleted())
                    .setCreatedAt(subjectRealization.getCreatedAt())
                    .setUpdatedAt(subjectRealization.getUpdatedAt());
    }

    public static List<SubjectRealizationDTO> map(List<SubjectRealization> subjectRealizations)
    {
        return subjectRealizations.stream().map(SubjectRealizationMapper::map).collect(Collectors.toList());
    }
}
