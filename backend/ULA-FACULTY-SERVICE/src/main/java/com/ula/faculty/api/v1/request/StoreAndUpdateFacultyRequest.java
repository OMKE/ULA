package com.ula.faculty.api.v1.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreAndUpdateFacultyRequest
{

    @NotEmpty(message = "Name is required")
    @Size(min = 10, message = "Name must be at least 5 characters long")
    @Size(max = 255, message = "Name can not be longer than 255 characters")
    private String name;

    @NotNull(message = "Campus id is required")
    @Min(value = 1, message = "Campus id can not be lower than 1")
    private Long campusId;

}
