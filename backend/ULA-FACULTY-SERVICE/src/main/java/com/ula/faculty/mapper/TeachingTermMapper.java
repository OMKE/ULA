package com.ula.faculty.mapper;

import com.ula.faculty.domain.model.TeachingTerm;
import com.ula.faculty.dto.model.TeachingMaterialDTO;
import com.ula.faculty.dto.model.TeachingTermDTO;
import com.ula.faculty.dto.model.TeachingTermOutcomeDTO;
import com.ula.faculty.dto.model.TeachingTypeDTO;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class TeachingTermMapper
{
    public static TeachingTermDTO map(TeachingTerm teachingTerm)
    {
        return new TeachingTermDTO()
                    .setId(teachingTerm.getId())
                    .setStartTime(teachingTerm.getStartTime())
                    .setEndTime(teachingTerm.getEndTime())
                    .setSubjectRealizationId(teachingTerm.getSubjectRealization().getId())
                    .setTeachingOutcome
                            (
                                    teachingTerm.getOutcome() != null ?
                                    new TeachingTermOutcomeDTO()
                                        .setId(teachingTerm.getOutcome().getId())
                                        .setTeachingTermId(teachingTerm.getId())
                                        .setDescription(teachingTerm.getOutcome().getDescription())
                                    : null
                            )
                    .setType(
                            teachingTerm.getType() != null ?
                            new TeachingTypeDTO()
                                .setId(teachingTerm.getType().getId())
                                .setName(teachingTerm.getType().getName())

                            : null
                            )
                    .setTeachingMaterial(
                            teachingTerm.getTeachingMaterial() != null ?
                            new TeachingMaterialDTO()
                                .setTeachingTermId(teachingTerm.getId())
                                .setId(teachingTerm.getTeachingMaterial().getId())
                                .setPublicationDate(teachingTerm.getTeachingMaterial().getPublicationDate())
                                .setAuthors(!teachingTerm.getTeachingMaterial().getAuthors().isEmpty() ?
                                            TeachingMaterialAuthorMapper.map(teachingTerm.getTeachingMaterial().getAuthors())
                                            : new HashSet<>()
                                            )
                                .setFiles(!teachingTerm.getTeachingMaterial().getFiles().isEmpty() ?
                                        FileMapper.mapFiles(teachingTerm.getTeachingMaterial().getFiles())
                                        : new HashSet<>()
                                        )

                            : null
                                        );


    }

    public static List<TeachingTermDTO> map(List<TeachingTerm> teachingTerms)
    {
        return teachingTerms.stream().map(TeachingTermMapper::map).collect(Collectors.toList());
    }






}
