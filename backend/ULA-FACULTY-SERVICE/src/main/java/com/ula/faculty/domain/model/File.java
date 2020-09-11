package com.ula.faculty.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.ula.core.domain.model.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class File extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TeachingMaterial teachingMaterial;

    @Column(nullable = false, columnDefinition = "VARCHAR(256)")
    private String path;

    @Column(nullable = false, columnDefinition = "VARCHAR(256)")
    private String description;

}
