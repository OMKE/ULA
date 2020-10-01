package com.ula.faculty.mapper;

import com.ula.faculty.domain.model.Subject;
import com.ula.faculty.domain.model.TeachingMaterial;
import com.ula.faculty.dto.model.TeachingMaterialDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TeachingMaterialMapper
{
    public static List<TeachingMaterialDTO> map(Subject subject)
    {
        return subject
                .getSubjectRealization()
                .getTeachingTerms()
                .stream()
                .filter(teachingTerm -> Objects.nonNull(teachingTerm.getTeachingMaterial()))
                .map(teachingTerm ->
                            TeachingMaterialMapper.map
                             (
                                teachingTerm.getTeachingMaterial()
                            )
                    ).collect(Collectors.toList());
    }

    public static TeachingMaterialDTO map(TeachingMaterial teachingMaterial)
    {
        return new TeachingMaterialDTO()
                .setId(teachingMaterial.getId())
                .setTeachingTermId(teachingMaterial.getTeachingTerm().getId())
                .setName(teachingMaterial.getName())
                .setPublicationDate(teachingMaterial.getPublicationDate())
                .setAuthors(
                        !teachingMaterial.getAuthors().isEmpty() ?
                                TeachingMaterialAuthorMapper.map(teachingMaterial.getAuthors())
                                : new HashSet<>()
                           )
                .setFiles(
                        !teachingMaterial.getFiles().isEmpty() ?
                                FileMapper.mapFiles(teachingMaterial.getFiles())
                                : new HashSet<>()
                         );


    }


}
