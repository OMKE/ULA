package com.ula.student.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExamDTO
{
    private Long id;
    @JsonIgnore
    private Long examTypeId;
    @JsonIgnore
    private Long takingExamId;
    private ExamEntryDTO examEntry;
    private Date startTime;
    private Date endTime;
    private double points;
    private String examType;
    private boolean finalExam;
}
