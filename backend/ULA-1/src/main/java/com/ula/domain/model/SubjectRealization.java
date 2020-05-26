package com.ula.domain.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class SubjectRealization extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(optional = false)
	private SubjectAttendance subjectAttendace;

	@OneToOne(mappedBy = "subjectRealization")
	private Subject subject;

	@OneToOne(mappedBy = "subjectRealization")
	private TeacherOnRealization teacherOnRealization;

	@OneToMany(mappedBy = "subjectRealization")
	private Set<TeachingTerm> teachingTerms;

}
