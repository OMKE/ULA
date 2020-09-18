package com.ula.teacher.api.v1.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreExamRequest
{

    @NotNull(message = "Exam type id is required")
    private Long typeId;

    @NotNull(message = "Exam term id is required")
    private Long examTermId;


    @NotNull(message = "Start time is required")
    private Date startTime;

    @NotNull(message = "End time is required")
    private Date endTime;

    @NotNull(message = "Final is required")
    private boolean finalExam;
}
