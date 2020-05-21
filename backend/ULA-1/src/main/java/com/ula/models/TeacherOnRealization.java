package com.ula.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teachers_on_realizations")
public class TeacherOnRealization extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, columnDefinition = "INT")
	private int numberOfLectures;

	@OneToOne
	private Teacher teacher;

	@OneToOne
	private SubjectRealization subjectRealization;

}