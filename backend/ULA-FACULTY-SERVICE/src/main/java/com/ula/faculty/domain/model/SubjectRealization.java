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

	/*
		@TODO
		@del *Pohadjanje predmeta*
		Vise studenata polaze jednu realizaciju predmeta
		Ovdje cuvamo ko je profa, koji je predmet u pitanju, a moci cemo ga dobiti preko studenta pa onda preko StudentAttendance(pohadjanje predmeta)
		Student service
		SubjectAttendance
		@OneToOne(optional = false)
		private SubjectAttendance subjectAttendance;
	 */


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


}
