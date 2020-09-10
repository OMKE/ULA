package com.ula.student.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class YearOfStudyDTO
{
    private Long id;
    private Double averageGrade;
    private int totalEspb;
    private List<SubjectAttendanceWithSubjectDTO> subjects;
}
