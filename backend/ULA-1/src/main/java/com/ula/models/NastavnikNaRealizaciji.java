package com.ula.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "nastavnikNaRealizaciji")

public class NastavnikNaRealizaciji {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Type(type = "int")
	private int brojCasova;

	@ManyToMany
	private Nastavnik nastavnik;

	@ManyToOne(optional = false)
	private TipNastave tipNastave;

	public NastavnikNaRealizaciji() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NastavnikNaRealizaciji(Long id, int brojCasova, Nastavnik nastavnik, TipNastave tipNastave) {
		super();
		this.id = id;
		this.brojCasova = brojCasova;
		this.nastavnik = nastavnik;
		this.tipNastave = tipNastave;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBrojCasova() {
		return brojCasova;
	}

	public void setBrojCasova(int brojCasova) {
		this.brojCasova = brojCasova;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public TipNastave getTipNastave() {
		return tipNastave;
	}

	public void setTipNastave(TipNastave tipNastave) {
		this.tipNastave = tipNastave;
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
		if (!(obj instanceof NastavnikNaRealizaciji)) {
			return false;
		}
		NastavnikNaRealizaciji other = (NastavnikNaRealizaciji) obj;
		return brojCasova == other.brojCasova && Objects.equals(id, other.id)
				&& Objects.equals(nastavnik, other.nastavnik) && Objects.equals(tipNastave, other.tipNastave);
	}
	
	

}
