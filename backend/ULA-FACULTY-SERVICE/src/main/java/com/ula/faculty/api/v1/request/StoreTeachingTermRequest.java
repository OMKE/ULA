package com.ula.faculty.api.v1.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreTeachingTermRequest
{
    private Long subjectRealizationId;
    private Long typeId;
    private Date startTime;
    private Date endTime;
    private String teachingMaterialName;
    private Date teachingMaterialPublicationDate;
    private String teachingMaterialAuthorFirstName;
    private String teachingMaterialAuthorLastName;
    private String teachingTermOutcomeDescription;

}
