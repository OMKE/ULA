package com.ula.teacher.api.v1.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreTeachingTermRequest
{
    // Validation is done in Faculty Service, we're returning Response from faculty service
    private Long subjectId;
    private Long typeId;
    private Date startTime;
    private Date endTime;
    private String teachingMaterialName;
    private Date teachingMaterialPublicationDate;
    private List<StoreTeachingMaterialAuthorRequest> authors;
    private String teachingTermOutcomeDescription;

}
