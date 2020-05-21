package com.ula.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private User user;

	/*
	 * Unique Master Citizen Number, name varies in each country
	 */
	@Column(nullable = false, unique = true, columnDefinition = "VARCHAR(256)")
	private String umcn;


	@Column(nullable = false, columnDefinition = "VARCHAR(64)")
	private String phoneNumber;
	
	@Column(columnDefinition = "DATETIME")
	private Date dateOfBirth;

	@OneToOne(mappedBy = "student")
	private SubjectAttendance subjectAttendances;

}
