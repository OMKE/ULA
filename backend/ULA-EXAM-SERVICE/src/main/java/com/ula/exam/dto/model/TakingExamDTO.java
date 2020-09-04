package com.ula.exam.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class TakingExamDTO
{
    private Long id;
    private Long subjectAttendanceId;
    private double points;
    private String note;
}
