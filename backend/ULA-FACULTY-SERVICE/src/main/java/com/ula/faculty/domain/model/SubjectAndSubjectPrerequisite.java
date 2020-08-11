package com.ula.faculty.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;


/*

    Join table between Subject and SubjectPrerequisite
    Many Subjects can have many SubjectPrerequisites because some subjects have the same prerequistes and subjects can have more than one prerequisite subject

 */

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class SubjectAndSubjectPrerequisite extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private SubjectPrerequisite subjectPrerequisite;
}
