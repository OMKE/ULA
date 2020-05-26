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
public class StudentOnYear extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, columnDefinition = "DATETIME")
	private Date dateOfEnrollment;
	
	@Column(nullable = false, unique = true, columnDefinition = "VARCHAR(64)")
	private String transcriptIdentifier;

	@OneToOne
	private Student student;
	
	@OneToMany(mappedBy = "studentOnYear")
	private Set<YearOfStudy> yearsOfStudy;
	
	@OneToMany(mappedBy = "studentOnYear")
	private Set<TakingExam> takenExams;
	
}
