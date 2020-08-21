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
