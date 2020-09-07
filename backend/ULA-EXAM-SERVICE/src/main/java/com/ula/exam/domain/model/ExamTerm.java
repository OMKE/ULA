package com.ula.exam.domain.model;

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
public class ExamTerm extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(128)")
    private String name;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private Date startDate;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private Date endDate;

    @OneToMany(mappedBy = "examTerm")
    private Set<ExamEntry> examEntries;



}
