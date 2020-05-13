package com.ula.models;

import java.util.Date;
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
@Table(name = "univerzitet")
public class Univerzitet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Type(type = "string")
	private String naziv;

	@Column
	@Type(type = "date")
	private Date datumOsnivanja;

	@ManyToOne(optional = false)
	private Adresa adresa;

	@ManyToOne(optional = false)
	private Nastavnik rektor;

	public Univerzitet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Univerzitet(Long id, String naziv, Date datumOsnivanja, Adresa adresa, Nastavnik rektor) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
		this.adresa = adresa;
		this.rektor = rektor;
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

	public Date getDatumOsnivanja() {
		return datumOsnivanja;
	}

	public void setDatumOsnivanja(Date datumOsnivanja) {
		this.datumOsnivanja = datumOsnivanja;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public Nastavnik getRektor() {
		return rektor;
	}

	public void setRektor(Nastavnik rektor) {
		this.rektor = rektor;
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
		if (!(obj instanceof Univerzitet)) {
			return false;
		}
		Univerzitet other = (Univerzitet) obj;
		return Objects.equals(adresa, other.adresa) && Objects.equals(datumOsnivanja, other.datumOsnivanja)
				&& Objects.equals(id, other.id) && Objects.equals(naziv, other.naziv)
				&& Objects.equals(rektor, other.rektor);
	}

	
	

}
