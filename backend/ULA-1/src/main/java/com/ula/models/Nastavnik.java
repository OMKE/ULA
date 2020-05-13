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
@Table(name = "nastavnik")

public class Nastavnik {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Type(type = "text")
	private String ime;
	
	@Column
	@Type(type = "text")
	private String biografija;
	
	@Column
	@Type(type = "text")
	private String jmbg;

	@ManyToOne(optional = false)
	private Zvanje zvanje;

	@ManyToOne(optional = false)
	private Adresa adresa;

	public Nastavnik() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Nastavnik(Long id, String ime, String biografija, String jmbg, Zvanje zvanje, Adresa adresa) {
		super();
		this.id = id;
		this.ime = ime;
		this.biografija = biografija;
		this.jmbg = jmbg;
		this.zvanje = zvanje;
		this.adresa = adresa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getBiografija() {
		return biografija;
	}

	public void setBiografija(String biografija) {
		this.biografija = biografija;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public Zvanje getZvanje() {
		return zvanje;
	}

	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
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
		if (!(obj instanceof Nastavnik)) {
			return false;
		}
		Nastavnik other = (Nastavnik) obj;
		return Objects.equals(adresa, other.adresa) && Objects.equals(biografija, other.biografija)
				&& Objects.equals(id, other.id) && Objects.equals(ime, other.ime) && Objects.equals(jmbg, other.jmbg);
	}
	
	

}
