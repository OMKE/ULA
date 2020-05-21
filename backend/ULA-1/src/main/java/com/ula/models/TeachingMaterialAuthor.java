package com.ula.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teaching_material_authors")
public class TeachingMaterialAuthor extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, columnDefinition = "VARCHAR(64)")
	private String firstName;

	@Column(nullable = false, columnDefinition = "VARCHAR(64)")
	private String lastName;

	@ManyToOne
	private TeachingMaterial teachingMaterial;
}