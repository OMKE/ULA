package com.ula.faculty.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.ula.core.domain.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class StudentOnYear extends BaseEntity
{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "BIGINT(20)")
    private Long studentId;

    @Column(nullable = false, columnDefinition = "DATETIME")
    private Date dateOfEnrollment;

    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(64)")
    private String transcriptIdentifier;


    @OneToMany(mappedBy = "student")
    private Set<SubjectAttendance> subjectAttendances;

    @OneToMany(mappedBy = "studentOnYear", cascade = CascadeType.ALL)
    private Set<StudentOnYearYearOfStudy> yearOfStudies;

//    One to Many TakingExam, TakingExam should hold points, date, exam and student Id, every student will have many TakingExam

}
