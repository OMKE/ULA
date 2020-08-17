
package com.ula.faculty.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FacultyDTO {

    private Long id;
    private Long universityId;
    private FacultyInformationDTO information;
    private Long campusId;
    private String name;
    private String icon;
    private Set<StudyProgramDTO> studyPrograms = new HashSet<StudyProgramDTO>() ;

}
