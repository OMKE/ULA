package com.ula.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class TeachingTerm extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, columnDefinition = "DATETIME")
	private Date startTime;

	@Column(nullable = false, columnDefinition = "DATETIME")
	private Date endTime;

	@ManyToOne
	private SubjectRealization subjectRealization;

	@OneToOne(mappedBy = "teachingTerm")
	private TeachingType teachingType;
}
