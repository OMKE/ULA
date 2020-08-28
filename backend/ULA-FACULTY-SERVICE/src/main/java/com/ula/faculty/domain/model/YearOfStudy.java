package com.ula.faculty.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.ula.core.domain.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class YearOfStudy extends BaseEntity
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Date year;

	/*
		- StudyProgram service
	 */

	@ManyToOne
	private StudyProgram studyProgram;

	/*
		- Student service
		Povezati studenta sa YearOfStudy
	 */

	@Column(nullable = false, columnDefinition = "INT")
	private int ordinalNumber;

	@OneToMany(mappedBy = "yearOfStudy", cascade = CascadeType.ALL)
	private Set<Subject> subjects;
}
