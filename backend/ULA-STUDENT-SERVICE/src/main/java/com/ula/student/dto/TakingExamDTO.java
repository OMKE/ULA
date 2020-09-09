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
public class TakingExamDTO
{
    private Long id;
    private Long subjectAttendanceId;
    private double points;
    private String note;
    private List<ExamDTO> exams;
}
