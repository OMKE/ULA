package com.ula.faculty.dto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class TeachingTermDTO
{
    private Long id;
    private Long subjectRealizationId;
    private TeachingTypeDTO type;
    private TeachingTermOutcomeDTO teachingOutcome;
    private TeachingMaterialDTO teachingMaterial;
    private Date startTime;
    private Date endTime;

}
