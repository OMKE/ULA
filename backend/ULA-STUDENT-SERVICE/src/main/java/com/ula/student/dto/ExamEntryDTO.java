package com.ula.student.dto;

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
    private Long examId;
    private boolean active;
}
