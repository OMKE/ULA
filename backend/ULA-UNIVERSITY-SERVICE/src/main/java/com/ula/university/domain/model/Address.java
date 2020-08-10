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
public class Address extends BaseEntity
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, columnDefinition = "VARCHAR(256)")
	private String streetName;
	
	@Column(nullable = false, columnDefinition = "VARCHAR(64)")
	private String number;

	@Column(nullable = false, columnDefinition = "VARCHAR(64)")
	private String postalCode;

	@OneToOne(fetch = FetchType.EAGER)
	private City city;



}
