package com.ula.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "predmet")

public class Predmet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Type(type = "string")
	private String naziv;

	@Column
	@Type(type = "int")
	private int espb;

	@Column
	@Type(type = "boolean")
	private boolean obavezan;

	@Column
	@Type(type = "int")
	private int brojPredavanja;

	@Column
	@Type(type = "int")
	private int brojVezbi;

	@Column
	@Type(type = "int")
	private int drugiObliciNastave;

	@Column
	@Type(type = "int")
	private int istrazivackiRad;

	@Column
	@Type(type = "int")
	private int ostaliCasovi;

	private Ishod ishod;

	private Predmet preduslov;

	private Ishod silabus;

}
