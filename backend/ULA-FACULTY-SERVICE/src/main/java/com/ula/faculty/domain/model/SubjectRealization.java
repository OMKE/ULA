package com.ula.faculty.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.ula.core.domain.model.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class SubjectRealization extends BaseEntity
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(optional = false)
	private Subject subject;


	/*
		ManyToMany - Join Table
		At least two teachers can teach one subject, but some teachers teach more than one subject
	 */
	@OneToMany(mappedBy = "subjectRealization")
	private Set<TeacherSubjectRealization> teachersOnRealization;

	@OneToMany(mappedBy = "subjectRealization")
	private Set<SubjectAttendance> subjectAttendance;

	/*
		@TODO
		@OneToMany(mappedBy = "subjectRealization")
		private Set<TeachingTerm> teachingTerms;
	 */

	@OneToMany(mappedBy = "subjectRealization")
	private Set<SubjectNotification> notifications;


}
