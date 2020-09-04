package com.ula.exam.api.v1.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreAndUpdateExamTypeRequest
{

    @NotEmpty(message = "Name is required")
    @Size(min = 3, message = "Name has to be at least 3 characters long")
    private String name;

}
