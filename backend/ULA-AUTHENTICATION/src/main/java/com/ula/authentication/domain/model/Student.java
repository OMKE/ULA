package com.ula.authentication.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
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

}
