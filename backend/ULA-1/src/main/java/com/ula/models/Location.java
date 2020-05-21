package com.ula.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location {

	
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