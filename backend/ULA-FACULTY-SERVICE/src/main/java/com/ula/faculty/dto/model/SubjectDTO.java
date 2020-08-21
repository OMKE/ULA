package com.ula.faculty.dto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
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

    /*
    @TODO
    @OneToMany(mappedBy = "subject")
    private Set<SubjectAndSubjectPrerequisite> prerequisites;

    @OneToMany(mappedBy = "subject")
    private Set<SubjectRealization> subjectRealization;
     */

}
