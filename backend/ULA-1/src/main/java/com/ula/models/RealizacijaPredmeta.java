package com.ula.models;

import java.util.Objects;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "realizacijaPredmeta")
public class RealizacijaPredmeta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false)
	private Predmet predmet;

	@ManyToOne(optional = false)
	private NastavnikNaRealizaciji nastavnikNaRealizaciji;

	public RealizacijaPredmeta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RealizacijaPredmeta(Long id, Predmet predmet, NastavnikNaRealizaciji nastavnikNaRealizaciji) {
		super();
		this.id = id;
		this.predmet = predmet;
		this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public NastavnikNaRealizaciji getNastavnikNaRealizaciji() {
		return nastavnikNaRealizaciji;
	}

	public void setNastavnikNaRealizaciji(NastavnikNaRealizaciji nastavnikNaRealizaciji) {
		this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
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
		if (!(obj instanceof RealizacijaPredmeta)) {
			return false;
		}
		RealizacijaPredmeta other = (RealizacijaPredmeta) obj;
		return Objects.equals(id, other.id);
	}
	
	



}
