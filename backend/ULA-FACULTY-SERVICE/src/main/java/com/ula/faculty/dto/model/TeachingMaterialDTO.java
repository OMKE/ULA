package com.ula.faculty.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class TeachingMaterialDTO
{

    private Long id;
    private Long teachingTermId;
    private String name;
    private Date publicationDate;
    private Set<TeachingMaterialAuthorDTO> authors;
    private Set<FileDTO> files;
}
