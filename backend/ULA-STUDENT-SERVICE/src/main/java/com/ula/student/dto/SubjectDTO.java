package com.ula.student.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class SubjectDTO
{
    private Long id;
    private Long yearOfStudyId;
    private String name;
    private int semester;
    private int espb;
    private boolean required;
    private int numberOfLectures;
    private int numberOfPracticalLectures;
    private int otherFormsOfLectures;
    private int researchWorks;
    private int otherLectures;
}
