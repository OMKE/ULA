package com.ula.teacher.api.v1.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreTeachingTermRequest
{
    @NotNull(message = "Subject id is required")
    private Long subjectId;

    @NotNull(message = "Type id id is required")
    private Long typeId;

    @NotNull(message = "Start time is required")
    @Future
    private Date startTime;

    @NotNull(message = "End time is required")
    @Future
    private Date endTime;

    @NotEmpty(message = "Teaching material name is required")
    @Size(min = 10, message = "Teaching material name has to be at least 10 characters long")
    @Size(max = 128, message = "Teaching material name cannot be longer than 128 characters")
    private String teachingMaterialName;

    @NotNull(message = "Teaching material publication date is required")
    private Date teachingMaterialPublicationDate;


    @NotEmpty(message = "Authors list cannot be empty")
    private List<@Valid StoreTeachingMaterialAuthorRequest> authors;

    @NotEmpty(message = "Outcome description is required")
    @Size(min = 20, message = "Outcome description has to be at least 20 characters long")
    @Size(max = 1000, message = "Outcome description cannot be longer than 1000 characters")
    private String teachingTermOutcomeDescription;

}
