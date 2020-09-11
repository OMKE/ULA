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
public class SubjectNotification extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private SubjectRealization subjectRealization;

    @ManyToOne(optional = false)
    private SubjectNotificationType type;

    @Column(nullable = false, columnDefinition = "VARCHAR(128)")
    private String text;
}
