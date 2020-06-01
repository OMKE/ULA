package com.ula.domain.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class Subject extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, columnDefinition = "VARCHAR(128)")
	private String name;
	
	@Column(nullable = false, columnDefinition = "INT")
	private int semestar;

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

	@ManyToMany
	private Set<Subject> prerequisites;

	@ManyToMany
	private Set<Subject> prerequisiteFor;

	@OneToOne
	private SubjectRealization subjectRealization;
}
