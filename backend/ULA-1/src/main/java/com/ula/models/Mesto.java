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
@Table(name = "mesto")
public class Mesto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	@Column
	@Type(type = "text")
	private String naziv;
	
	@ManyToOne(optional = false)
	private Drzava drzava;

	public Mesto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mesto(Long id, String naziv, Drzava drzava) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.drzava = drzava;
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

	public Drzava getDrzava() {
		return drzava;
	}

	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
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
		if (!(obj instanceof Mesto)) {
			return false;
		}
		Mesto other = (Mesto) obj;
		return Objects.equals(drzava, other.drzava) && Objects.equals(id, other.id)
				&& Objects.equals(naziv, other.naziv);
	}
	
	
	

}
