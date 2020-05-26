package com.ula.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SubjectAttendance extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, columnDefinition = "INT")
	private int finalGrade;

	@OneToOne(mappedBy = "subjectAttendace")
	private SubjectRealization subjectRealization;

	@OneToOne
	private Student student;

	public SubjectAttendance() {
		super();
	}

	public SubjectAttendance(Long id, int finalGrade, SubjectRealization subjectRealization,
			Student student) {
		super();
		this.id = id;
		this.finalGrade = finalGrade;
		this.subjectRealization = subjectRealization;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(int finalGrade) {
		this.finalGrade = finalGrade;
	}

	public SubjectRealization getSubjectRealization() {
		return subjectRealization;
	}

	public void setSubjectRealization(SubjectRealization subjectRealization) {
		this.subjectRealization = subjectRealization;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
