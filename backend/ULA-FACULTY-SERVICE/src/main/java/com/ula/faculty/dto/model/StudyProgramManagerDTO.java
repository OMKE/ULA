package com.ula.faculty.dto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class StudyProgramManagerDTO
{
    private Long id;
    private Long studyProgramId;
    private String firstName;
    private String lastName;
    private String title;
    private String phoneNumber;
    private String email;
}
