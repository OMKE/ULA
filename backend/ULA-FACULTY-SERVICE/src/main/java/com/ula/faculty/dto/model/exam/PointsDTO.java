package com.ula.faculty.dto.model.exam;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PointsDTO
{
    private Long subjectAttendanceId;
    private Long takingExamId;
    private String subject;
    private boolean hasFinal;
    private double points;
    private List<ExamDTO> exams;

}
