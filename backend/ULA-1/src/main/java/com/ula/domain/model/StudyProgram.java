package com.ula.domain.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class StudyProgram extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, columnDefinition = "VARCHAR(256)")
	private String name;

	@OneToOne(mappedBy = "studyProgram")
	private YearOfStudy yearOfStudy;

	/*
	 * Location like Main campus etc...
	 */

	@OneToOne(fetch = FetchType.EAGER)
	private StudyProgramLocation location;

	@OneToOne(fetch = FetchType.EAGER)
	private StudyProgramDegree degree;

	@ManyToOne(optional = false)
	private Faculty faculty;
	
	@OneToMany(mappedBy = "studyProgram")
	private Set<YearOfStudy> yearsOfStudy;
}
