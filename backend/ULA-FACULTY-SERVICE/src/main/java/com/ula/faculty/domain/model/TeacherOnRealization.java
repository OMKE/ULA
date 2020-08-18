package com.ula.faculty.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class TeacherOnRealization extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/*
		- Auth Service holds teachers
	 */
	private Long teacherId;

	@Column(nullable = false, columnDefinition = "INT")
	private int numberOfLectures;

	@OneToMany(mappedBy = "teacherOnRealization")
	private Set<TeacherSubjectRealization> subjectRealization;

}
