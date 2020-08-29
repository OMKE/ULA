package com.ula.faculty.dto.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudyProgramDTO
{
    private Long id;
    private Long facultyId;
    private String name;
    private String description;
    private StudyProgramLocationDTO location;
    private StudyProgramDegreeDTO degree;
//    @OneToMany(mappedBy = "studyProgram")
//    private Set<YearOfStudy> yearsOfStudy;
}
