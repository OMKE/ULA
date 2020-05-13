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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "fakultet")

public class Fakultet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Type(type = "string")
	private String naziv;

	@ManyToOne(optional = false)
	private Adresa adresa;

	@ManyToOne(optional = false)
	private Nastavnik dekan;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fakultet", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<StudijskiProgram> studijskiProgram = new ArrayList<>();
	
	@ManyToOne(optional = false)
	private Univerzitet univerzitet;

	public Fakultet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fakultet(Long id, String naziv, Adresa adresa, Nastavnik dekan, List<StudijskiProgram> studijskiProgram,
			Univerzitet univerzitet) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.dekan = dekan;
		this.studijskiProgram = studijskiProgram;
		this.univerzitet = univerzitet;
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

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public Nastavnik getDekan() {
		return dekan;
	}

	public void setDekan(Nastavnik dekan) {
		this.dekan = dekan;
	}

	public List<StudijskiProgram> getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(List<StudijskiProgram> studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}

	public Univerzitet getUniverzitet() {
		return univerzitet;
	}

	public void setUniverzitet(Univerzitet univerzitet) {
		this.univerzitet = univerzitet;
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
		if (!(obj instanceof Fakultet)) {
			return false;
		}
		Fakultet other = (Fakultet) obj;
		return Objects.equals(adresa, other.adresa) && Objects.equals(dekan, other.dekan)
				&& Objects.equals(id, other.id) && Objects.equals(naziv, other.naziv)
				&& Objects.equals(studijskiProgram, other.studijskiProgram)
				&& Objects.equals(univerzitet, other.univerzitet);
	}

	
	

}
