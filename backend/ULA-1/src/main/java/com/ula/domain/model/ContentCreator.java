package com.ula.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ContentCreator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private User user;

	@OneToMany(mappedBy = "contentCreator")
	private Set<NewsArticle> newsArticles;

	@OneToMany(mappedBy = "contentCreator")
	private Set<ResearchProject> researchProjects;

}
