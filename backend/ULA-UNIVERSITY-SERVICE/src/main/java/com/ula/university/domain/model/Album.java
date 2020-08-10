package com.ula.university.domain.model;

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
public class Album extends BaseEntity
{

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
