package com.ula.domain.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

@Entity
public class University extends BaseEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, columnDefinition = "VARCHAR(256)")
	@Type(type = "text")
	private String name;
	
	@Column(nullable = false)
	@Type(type = "date")
	private Date establishmentDate;

	@OneToMany(mappedBy = "university", fetch = FetchType.LAZY)
	private List<Faculty> faculties;

	@OneToOne
	private Address address;
	
	@OneToMany(mappedBy = "university")
	private Set<PhoneNumber> phoneNumbers;

}
