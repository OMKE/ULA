package com.ula.exam.dto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class ExamDTO
{
    private Long id;
    private Long examTypeId;
    private Long takingExamId;
    @JsonFormat(pattern = "YYYY-MM-DD HH:MM:SS")
    private Date startTime;
    @JsonFormat(pattern = "YYYY-MM-DD HH:MM:SS")
    private Date endTime;
    private double points;
    private String examType;
    private boolean finalExam;
}
