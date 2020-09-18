package com.ula.faculty.dto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class TeacherOnRealizationDTO
{
    private Long id;
    private Long teacherId;
    private int numberOfLectures;

}
