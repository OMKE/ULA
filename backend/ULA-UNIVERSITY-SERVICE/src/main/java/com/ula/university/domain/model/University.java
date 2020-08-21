package com.ula.university.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class University extends BaseEntity
{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, columnDefinition = "VARCHAR(256)")
	@Type(type = "text")
	private String name;
	
	@Column(nullable = false)
	@Type(type = "date")
	private Date establishmentDate;

	/*
		- Faculty Service
		getAllFaculties on this university
	 */

	@OneToOne
	private Address address;

	@OneToOne(mappedBy = "university")
	private UniversityInformation universityAbout;
	
	@OneToMany(mappedBy = "university")
	private Set<PhoneNumber> phoneNumbers;

}
