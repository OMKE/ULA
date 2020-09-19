package com.ula.faculty.dto.model.exam;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class ExamEntryDTO
{
    private Long id;
    private Long examTermId;
    private String examTerm;
    private Long examId;
    private boolean active;
}
