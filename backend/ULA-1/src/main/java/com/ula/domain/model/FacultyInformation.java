package com.ula.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class FacultyInformation extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String history;

	/*
	 * Should be wysiwyg
	 */
	@Column(nullable = false, columnDefinition = "TEXT")
	private String president;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String mission;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String accreditation;
	
	/*
	 * Map in location
	 */


	@Column(nullable = false, columnDefinition = "VARCHAR(128)")
	private String email;

	@OneToOne
	private Address address;

	@Column(nullable = false, columnDefinition = "VARCHAR(64)")
	private String phoneNumber;

}
