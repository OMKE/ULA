package com.ula.exam.api.v1.request;

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
public class UpdateTakingExamRequest
{

    @NotNull(message = "Points are required")
    @Min(value = 0, message = "Points have to be higher than 0")
    @Max(value = 100, message = "Points can not be higher than 100")
    private Double points;
}
