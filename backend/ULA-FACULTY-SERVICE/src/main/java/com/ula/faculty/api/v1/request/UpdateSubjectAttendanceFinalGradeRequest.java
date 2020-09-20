package com.ula.faculty.api.v1.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateSubjectAttendanceFinalGradeRequest
{

    @NotNull(message = "Final grade is required")
    @Min(value = 1, message = "Final grade can not be lower than 1")
    @Max(value = 10, message = "Final grade can not be higher than 10")
    private Integer finalGrade;

}
