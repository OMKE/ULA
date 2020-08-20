package com.ula.faculty.dto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
public class YearOfStudyDTO
{
    private Long id;
    private Date year;
    private int ordinalNumber;
    private Long studyProgramId;
    private Date created_at;
}
