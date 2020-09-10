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
public class Subject extends BaseEntity
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, columnDefinition = "VARCHAR(128)")
	private String name;
	
	@Column(nullable = false, columnDefinition = "INT")
	private int semester;

	@Column(nullable = false, columnDefinition = "INT")
	private int espb;
	
	@Column(nullable = false, columnDefinition = "bool default true")
	private boolean required;

	@Column(nullable = false, columnDefinition = "INT")
	private int numberOfLectures;

	@Column(nullable = false, columnDefinition = "INT")
	private int numberOfPracticalLectures;

	@Column(nullable = false, columnDefinition = "INT")
	private int otherFormsOfLectures;
	
	@Column(nullable = false, columnDefinition = "INT")
	private int researchWorks;

	@Column(nullable = false, columnDefinition = "INT")
	private int otherLectures;

	@OneToMany(mappedBy = "subject")
	private Set<SubjectAndSubjectPrerequisite> prerequisites;

	@OneToOne(mappedBy = "subject")
	private SubjectRealization subjectRealization;

	@OneToOne(mappedBy = "subject")
	private SubjectSyllabus syllabus;

	@ManyToOne
	private YearOfStudy yearOfStudy;
}
