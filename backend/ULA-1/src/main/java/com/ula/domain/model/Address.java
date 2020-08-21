package com.ula.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Address extends BaseEntity {

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
