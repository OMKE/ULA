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
public class StoreAndUpdateStudyProgramRequest
{

    @NotEmpty(message = "Name is required")
    @Size(min = 6, message = "Name must be at least 6 characters long")
    @Size(max = 255, message = "Name can not be longer than 255 characters")
    private String name;

    @NotEmpty(message = "Description is required")
    @Size(min = 20, message = "Description must be at least 20 characters long")
    private String description;

    @NotNull(message = "Faculty id is required")
    @Min(value = 1, message = "Faculty id can not be lower than 1")
    private Long facultyId;


    @NotNull(message = "Location id is required")
    @Min(value = 1, message = "Location id can not be lower than 1")
    private Long locationId;

    @NotNull(message = "Degree id is required")
    @Min(value = 1, message = "Degree id can not be lower than 1")
    private Long degreeId;


}
