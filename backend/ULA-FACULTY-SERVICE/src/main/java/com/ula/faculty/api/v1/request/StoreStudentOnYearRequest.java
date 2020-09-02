package com.ula.faculty.api.v1.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreStudentOnYearRequest
{
    @NotNull(message = "Student id is required")
    @Min(value = 1, message = "Student id can not be lower than 1")
    private Long studentId;

    @NotNull(message = "Year of study id is required")
    @Min(value = 1, message = "Student id can not be lower than 1")
    private Long yearOfStudyId;

    @NotNull(message = "Date of enrollment is required")
    private Date dateOfEnrollment;

}
