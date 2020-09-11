package com.ula.faculty.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.ula.core.domain.model.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class StudyProgramManager extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(optional = false)
    private StudyProgram studyProgram;

    @Column(nullable = false, columnDefinition = "VARCHAR(128)")
    private String firstName;

    @Column(nullable = false, columnDefinition = "VARCHAR(128)")
    private String lastName;

    @Column(nullable = false, columnDefinition = "VARCHAR(64)")
    private String title;

    @Column(nullable = false, columnDefinition = "VARCHAR(64)")
    private String phoneNumber;

    @Column(nullable = false, columnDefinition = "VARCHAR(128)")
    private String email;

}
