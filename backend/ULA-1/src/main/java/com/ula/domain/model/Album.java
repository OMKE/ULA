package com.ula.domain.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Album extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, columnDefinition = "VARCHAR(128)")
	private String name;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String description;

	@ManyToOne
	private Gallery gallery;

	@OneToMany(mappedBy = "album")
	private Set<Image> images;

}
