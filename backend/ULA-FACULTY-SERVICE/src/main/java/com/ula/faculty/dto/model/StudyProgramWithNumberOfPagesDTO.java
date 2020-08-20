package com.ula.faculty.dto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class StudyProgramWithNumberOfPagesDTO
{
    List<StudyProgramDTO> studyPrograms;
    int totalPages;

}
