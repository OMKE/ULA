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
@Table(name = "adresa")
public class Adresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Type(type = "text")
	private String ulica;

	@Column
	@Type(type = "text")
	private String broj;

	@ManyToOne(optional = false)
	private Mesto mesto;

	public Adresa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adresa(Long id, String ulica, String broj, Mesto mesto) {
		super();
		this.id = id;
		this.ulica = ulica;
		this.broj = broj;
		this.mesto = mesto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	public Mesto getMesto() {
		return mesto;
	}

	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
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
		if (!(obj instanceof Adresa)) {
			return false;
		}
		Adresa other = (Adresa) obj;
		return Objects.equals(broj, other.broj) && Objects.equals(id, other.id) && Objects.equals(mesto, other.mesto)
				&& Objects.equals(ulica, other.ulica);
	}

	

}
