package com.ula.models;

import java.util.Date;
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
@Table(name = "teaching_materials")
public class TeachingMaterial extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "teachingMaterial")
	private Set<TeachingMaterialAuthor> authors;
	
	
	@Column(nullable = false, columnDefinition = "DATETIME")
	private Date publishmentDate;

	@OneToOne
	private File file;
}