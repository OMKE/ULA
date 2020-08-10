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
public class Location
{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(nullable = false, columnDefinition = "VARCHAR(64)")
	private double longitude;

	@Column(nullable = false, columnDefinition = "VARCHAR(64)")
	private double latitude;

	@Column(nullable = false, columnDefinition = "VARCHAR(128)")
	private String name;

}
