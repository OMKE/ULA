package com.ula.exam.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.ula.core.domain.model.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class TakingExam extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long subjectAttendanceId;

    @Column(columnDefinition = "DOUBLE")
    private double points;

    @Column(columnDefinition = "TEXT")
    private String note;

    @OneToMany(mappedBy = "takingExam")
    private Set<Exam> exams;



}
