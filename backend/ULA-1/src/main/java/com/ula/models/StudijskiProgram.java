package com.ula.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "studijskiProgram")

public class StudijskiProgram {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Type(type = "string")
	private String naziv;

	@ManyToOne(optional= false)
	private Nastavnik rukovodilac;
	
	@ManyToOne(optional = false)
	private Fakultet fakultet;

	public StudijskiProgram() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudijskiProgram(Long id, String naziv, Nastavnik rukovodilac, Fakultet fakultet) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.rukovodilac = rukovodilac;
		this.fakultet = fakultet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Nastavnik getRukovodilac() {
		return rukovodilac;
	}

	public void setRukovodilac(Nastavnik rukovodilac) {
		this.rukovodilac = rukovodilac;
	}

	public Fakultet getFakultet() {
		return fakultet;
	}

	public void setFakultet(Fakultet fakultet) {
		this.fakultet = fakultet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;  
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof StudijskiProgram)) {
			return false;
		}
		StudijskiProgram other = (StudijskiProgram) obj;
		return Objects.equals(fakultet, other.fakultet) && Objects.equals(id, other.id)
				&& Objects.equals(naziv, other.naziv) && Objects.equals(rukovodilac, other.rukovodilac);
	}
	
	

}
