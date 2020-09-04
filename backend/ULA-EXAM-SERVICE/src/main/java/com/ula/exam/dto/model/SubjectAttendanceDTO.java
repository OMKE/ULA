package com.ula.exam.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class SubjectAttendanceDTO
{
    private Long id;
    private Long studentId;
    private Long subjectRealizationId;
    private Integer finalGrade;
    private boolean deleted;
    private Date createdAt;
    private Date updatedAt;
}
