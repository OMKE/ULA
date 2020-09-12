package com.ula.faculty.api.v1.request;

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
public class StoreAndUpdateSubjectRequest
{

    @NotNull(message = "Year of study id is required")
    @Min(value = 1, message = "Year of study id can not be lower than 1")
    private Long yearOfStudyId;

    @NotEmpty(message = "Name is required")
    @Size(min = 3, message = "Name has to be at least 3 characters long")
    @Size(max = 128, message = "Name can not be longer than 128 characters")
    private String name;

    @NotNull(message = "Semester is required")
    @Min(value = 1, message = "Semester can not be lower than 1")
    @Max(value = 20, message = "Semester can not be higher than 20")
    private int semester;

    @NotNull(message = "Semester is required")
    @Min(value = 1, message = "Espb can not be lower than 1")
    @Max(value = 8, message = "Espb can not be higher than 8")
    private int espb;

    @NotNull(message = "Required field is required")
    private boolean required;

    @NotNull(message = "Number of lectures is required")
    @Min(value = 5, message = "Number of lectures can not be lower than 5")
    @Max(value = 50, message = "Number of lectures can not be higher than 50")
    private int numberOfLectures;

    @NotNull(message = "Number of practical lectures of lectures is required")
    @Max(value = 50, message = "Semester can not be higher than 50")
    private int numberOfPracticalLectures;

    @NotNull(message = "Other forms of lectures field is required")
    @Max(value = 20, message = "Number of other forms of lectures can not be higher than 20")
    private int otherFormsOfLectures;

    @NotNull(message = "Research works field is required")
    @Max(value = 5, message = "Number of research works can not be higher than 5")
    private int researchWorks;

    @NotNull(message = "Number of other lectures is required")
    @Max(value = 10, message = "Number of other lectures can not be higher than 10")
    private int otherLectures;

    @NotEmpty(message = "Subject syllabus is required")
    @Size(min = 50, message = "Subject syllabus has to be at least 50 characters long")
    private String syllabus;

}
