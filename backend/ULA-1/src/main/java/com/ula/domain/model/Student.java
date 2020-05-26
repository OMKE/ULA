package com.ula.domain.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
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

	public Student() {
		super();
	}

	public Student(Long id, User user, String umcn, String phoneNumber, Date dateOfBirth,
			SubjectAttendance subjectAttendances) {
		super();
		this.id = id;
		this.user = user;
		this.umcn = umcn;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.subjectAttendances = subjectAttendances;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUmcn() {
		return umcn;
	}

	public void setUmcn(String umcn) {
		this.umcn = umcn;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public SubjectAttendance getSubjectAttendances() {
		return subjectAttendances;
	}

	public void setSubjectAttendances(SubjectAttendance subjectAttendances) {
		this.subjectAttendances = subjectAttendances;
	}

}
