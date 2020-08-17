package com.ula.university.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@Entity
public class UniversityInformation extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private University university;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String about;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String history;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String president;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String teachingStaff;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String publishing;


}
