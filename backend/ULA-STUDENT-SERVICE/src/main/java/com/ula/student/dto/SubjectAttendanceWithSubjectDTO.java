package com.ula.student.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class SubjectAttendanceWithSubjectDTO
{
    private Long id;
    private Long studentId;
    private SubjectWithRealizationIdDTO subject;
    private Integer finalGrade;
}
