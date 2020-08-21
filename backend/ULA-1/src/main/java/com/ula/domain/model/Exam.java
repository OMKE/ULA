package com.ula.domain.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Exam extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, columnDefinition = "DATETIME")
	private Date startTime;

	@Column(nullable = false, columnDefinition = "DATETIME")
	private Date endTime;

	@Column(nullable = false, columnDefinition = "DOUBLE")
	private double points;

	@OneToOne
	private ExamType type;

	@OneToOne
	private ExamOutcome examOutcome;

	@OneToMany(mappedBy = "exam")
	private Set<TakingExam> takingExams;

}
