package com.ula.faculty.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class SubjectRealizationDTO
{
    private Long id;
    private Long subjectId;
    private boolean deleted;
    private Date createdAt;
    private Date updatedAt;
}
