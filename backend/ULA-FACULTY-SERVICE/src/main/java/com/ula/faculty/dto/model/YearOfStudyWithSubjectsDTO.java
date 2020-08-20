package com.ula.faculty.dto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class YearOfStudyWithSubjectsDTO
{
    private Long id;
    private Date year;
    private int ordinalNumber;
    private Long studyProgramId;
    private Date created_at;
    private List<SubjectDTO> subjects;
}
