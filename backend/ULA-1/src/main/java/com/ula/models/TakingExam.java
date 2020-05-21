package com.ula.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "taking_exams")
public class TakingExam extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, columnDefinition = "DOUBLE")
	private double points;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String note;

	@ManyToOne
	private Exam exam;

	@ManyToOne
	private StudentOnYear studentOnYear;
}
