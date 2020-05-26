package com.ula.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class NewsArticle extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false)
	private ContentCreator contentCreator;

	@Column(nullable = false, columnDefinition = "VARCHAR(256)")
	private String thumbnailImage;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String html;


}
