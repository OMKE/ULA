package com.ula.faculty.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
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
public class TeachingMaterial extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    private TeachingTerm teachingTerm;

    @Column(nullable = false, columnDefinition = "VARCHAR(128)")
    private String name;

    @Column(nullable = false, columnDefinition = "DATE")
    private Date publicationDate;

    @OneToMany(mappedBy = "teachingMaterial")
    private Set<TeachingMaterialAuthor> authors;

    @OneToMany(mappedBy = "teachingMaterial")
    private Set<File> files;
}
