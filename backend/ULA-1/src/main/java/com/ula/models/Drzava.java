package com.ula.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "drzava")
public class Drzava {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Type(type = "text")
	private String naziv;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "drzava", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<Mesto> mesto = new ArrayList<>();

	public Drzava() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Drzava(Long id, String naziv, List<Mesto> mesto) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.mesto = mesto;
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

	public List<Mesto> getMesto() {
		return mesto;
	}

	public void setMesto(List<Mesto> mesto) {
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
		if (!(obj instanceof Drzava)) {
			return false;
		}
		Drzava other = (Drzava) obj;
		return Objects.equals(id, other.id) && Objects.equals(mesto, other.mesto) && Objects.equals(naziv, other.naziv);
	}
	
	

}
