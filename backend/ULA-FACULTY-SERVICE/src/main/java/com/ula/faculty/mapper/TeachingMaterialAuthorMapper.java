package com.ula.faculty.mapper;

import com.ula.faculty.domain.model.TeachingMaterialAuthor;
import com.ula.faculty.dto.model.TeachingMaterialAuthorDTO;

import java.util.Set;
import java.util.stream.Collectors;

public class TeachingMaterialAuthorMapper
{
    public static TeachingMaterialAuthorDTO map(TeachingMaterialAuthor author)
    {
        return new TeachingMaterialAuthorDTO()
                .setId(author.getId())
                .setFirstName(author.getFirstName())
                .setLastName(author.getLastName())
                .setTeachingMaterialId(author.getTeachingMaterial().getId());
    }

    public static Set<TeachingMaterialAuthorDTO> map(Set<TeachingMaterialAuthor> authors)
    {
        return authors.stream().map(TeachingMaterialAuthorMapper::map).collect(Collectors.toSet());
    }
}
