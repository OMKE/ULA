package com.ula.faculty.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class TakingExam
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DOUBLE")
    private double points;

    @Column(columnDefinition = "TEXT")
    private String note;

    @OneToMany(mappedBy = "takingExam")
    private Set<Exam> exam;

    @ManyToOne
    private SubjectAttendance subjectAttendance;

}
