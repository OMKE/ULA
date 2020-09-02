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

	@ManyToOne
	private StudyProgram studyProgram;


	@Column(nullable = false, columnDefinition = "INT")
	private int ordinalNumber;

	@OneToMany(mappedBy = "yearOfStudy", cascade = CascadeType.ALL)
	private Set<Subject> subjects;

	@OneToMany(mappedBy = "yearOfStudy")
	private Set<StudentOnYearYearOfStudy> students;
}
