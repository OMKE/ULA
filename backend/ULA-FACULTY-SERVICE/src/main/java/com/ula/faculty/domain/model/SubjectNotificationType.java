package com.ula.faculty.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.ula.core.domain.model.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class SubjectNotificationType extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(32)")
    private String name;

    @OneToMany(mappedBy = "type")
    private Set<SubjectNotification> subjectNotification;
}
