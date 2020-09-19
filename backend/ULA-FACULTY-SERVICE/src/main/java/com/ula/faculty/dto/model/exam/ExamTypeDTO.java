package com.ula.faculty.dto.model.exam;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class ExamTypeDTO
{
    private Long id;
    private String name;
}
