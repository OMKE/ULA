package com.ula.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Image extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, columnDefinition = "VARCHAR(256)")
	private String path;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String description;

	@Column(nullable = true, columnDefinition = "VARCHAR(128)")
	private String name;

	@ManyToOne
	private Album album;
}
