package com.ula.faculty.domain.model;

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
public class SubjectAttendance extends BaseEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "INT")
    private int finalGrade;

    @ManyToOne(optional = false)
    private SubjectRealization subjectRealization;

    @ManyToOne
    private StudentOnYear student;

    @OneToMany(mappedBy = "subjectAttendance")
    private Set<TakingExam> takingExams;

}
