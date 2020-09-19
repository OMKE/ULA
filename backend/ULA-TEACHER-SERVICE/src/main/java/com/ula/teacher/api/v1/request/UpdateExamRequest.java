package com.ula.teacher.api.v1.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateExamRequest
{
    @NotNull(message = "Points are required")
    @Min(value = 0, message = "Points can not be lower than 0")
    @Max(value = 30, message = "Points are limited to 30")
    private Double points;

    @NotEmpty(message = "Description is required")
    @Size(min = 10, message = "Description has to be at least 10 characters long")
    @Size(max = 400, message = "Description can not be longer than 400 characters")
    private String description;
}
