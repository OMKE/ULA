package com.ula.student.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Long examTermId;
    private String examTerm;
    @JsonIgnore
    private Long examId;
    private boolean active;
}
