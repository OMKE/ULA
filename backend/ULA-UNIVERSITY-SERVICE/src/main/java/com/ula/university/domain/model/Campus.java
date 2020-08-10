package com.ula.university.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class Campus extends BaseEntity
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/*
		- Faculty Service
		Faculties that are on this campus
	 */


	@Column(nullable = false, columnDefinition = "VARCHAR(128)")
	private String name;

	@OneToOne
	private Location location;

}
