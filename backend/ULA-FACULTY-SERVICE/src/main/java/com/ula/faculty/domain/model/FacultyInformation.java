package com.ula.faculty.domain.model;

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
public class FacultyInformation extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Faculty faculty;

	private Long addressId;

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

	@Column(nullable = false, columnDefinition = "VARCHAR(64)")
	private String phoneNumber;

}
