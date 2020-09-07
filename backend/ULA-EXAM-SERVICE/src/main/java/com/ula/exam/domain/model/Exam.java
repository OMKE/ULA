package com.ula.exam.domain.model;

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

	@Column(nullable = false, columnDefinition = "TIMESTAMP")
	private Date startTime;

	@Column(nullable = false, columnDefinition = "TIMESTAMP")
	private Date endTime;

	@Column(nullable = false, columnDefinition = "DOUBLE")
	private double points;

	@Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
	private boolean finalExam;

	@ManyToOne(optional = false)
	private ExamType type;

	@OneToOne(mappedBy = "exam", optional = false)
	private ExamOutcome examOutcome;

	@ManyToOne(optional = false)
	private TakingExam takingExam;

	@OneToOne(mappedBy = "exam", optional = false)
	private ExamEntry examEntry;

}
