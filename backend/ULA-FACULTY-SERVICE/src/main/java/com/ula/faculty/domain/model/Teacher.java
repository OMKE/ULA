package com.ula.faculty.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.hateoas.RepresentationModel;

import java.util.Set;


@NoArgsConstructor
@Accessors(chain = true)
@Data
public class Teacher extends RepresentationModel<Teacher>
{

	private Long id;
	private Long userId;
	private String biography;
	private Set<Subject> subjects;

}
