package com.ula.faculty.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.ula.core.domain.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class Exam extends BaseEntity
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, columnDefinition = "DATETIME")
	private Date startTime;

	@Column(nullable = false, columnDefinition = "DATETIME")
	private Date endTime;

	@Column(nullable = false, columnDefinition = "DOUBLE")
	private double points;

	@ManyToOne
	private ExamType type;

	@OneToOne(mappedBy = "exam")
	private ExamOutcome examOutcome;

	@ManyToOne
	private TakingExam takingExam;

}
