package com.ula.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "campuses")
public class Campus extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "campus")
	private Set<Faculty> faculties;

	@Column(nullable = false, columnDefinition = "VARCHAR(128)")
	private String name;

	@OneToOne
	private Location location;

}
