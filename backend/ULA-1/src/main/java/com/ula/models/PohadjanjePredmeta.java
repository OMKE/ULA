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
@Table(name = "pohadjanjePredmeta")
public class PohadjanjePredmeta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Type(type = "int")
	private int konacnaOcena;

	@ManyToOne(optional = false)
	private RealizacijaPredmeta realizacijaPredmeta;

	public PohadjanjePredmeta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PohadjanjePredmeta(Long id, int konacnaOcena, RealizacijaPredmeta realizacijaPredmeta) {
		super();
		this.id = id;
		this.konacnaOcena = konacnaOcena;
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getKonacnaOcena() {
		return konacnaOcena;
	}

	public void setKonacnaOcena(int konacnaOcena) {
		this.konacnaOcena = konacnaOcena;
	}

	public RealizacijaPredmeta getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmeta realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
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
		if (!(obj instanceof PohadjanjePredmeta)) {
			return false;
		}
		PohadjanjePredmeta other = (PohadjanjePredmeta) obj;
		return Objects.equals(id, other.id) && konacnaOcena == other.konacnaOcena
				&& Objects.equals(realizacijaPredmeta, other.realizacijaPredmeta);
	}
	
	

}
