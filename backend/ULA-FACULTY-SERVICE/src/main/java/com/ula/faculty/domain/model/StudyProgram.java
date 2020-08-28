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
public class StudyProgram extends BaseEntity
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, columnDefinition = "VARCHAR(256)")
	private String name;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String description;

	@OneToMany(mappedBy = "studyProgram")
	private Set<YearOfStudy> yearOfStudy;

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
