package com.ula.exam.api.v1.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateExamRequest
{

    @NotNull(message = "Points are required")
    private double points;

    @NotEmpty(message = "Description is required")
    @Size(min = 10, message = "Description has to be at least 10 characters long")
    @Size(max = 400, message = "Description can not be longer than 400 characters")
    private String description;
}
