package com.ula.domain.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Faculty extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, columnDefinition = "VARCHAR(256)")
	private String name;

	@ManyToOne(optional = false)
	private University university;

	@ManyToOne(optional = false)
	private Campus campus;


	@OneToOne(fetch = FetchType.LAZY)
	private FacultyInformation information;

	@OneToMany(mappedBy = "faculty", fetch = FetchType.LAZY)
	private List<StudyProgram> studyPrograms;
}
