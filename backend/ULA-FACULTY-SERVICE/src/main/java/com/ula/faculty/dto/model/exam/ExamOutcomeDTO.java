package com.ula.faculty.dto.model.exam;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class ExamOutcomeDTO
{
    private Long id;
    private Long examId;
    private String description;
}
