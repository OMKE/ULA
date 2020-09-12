package com.ula.faculty.dto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class TeachingTermOutcomeDTO
{
    private Long id;
    private Long teachingTermId;
    private Long educationalGoalId;
    private String description;
}
