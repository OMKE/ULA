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
@Table(name = "zvanje")

public class Zvanje {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Type(type = "date")
	private Date datumIzbora;
	
	@Column
	@Type(type = "date")
	private Date datumPrestanka;

	@ManyToOne(optional = false)
	private TipZvanja tipZvanja;

	@ManyToOne(optional = false)
	private NaucnaOblast naucnaOblast;

	public Zvanje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Zvanje(Long id, Date datumIzbora, Date datumPrestanka, TipZvanja tipZvanja, NaucnaOblast naucnaOblast) {
		super();
		this.id = id;
		this.datumIzbora = datumIzbora;
		this.datumPrestanka = datumPrestanka;
		this.tipZvanja = tipZvanja;
		this.naucnaOblast = naucnaOblast;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatumIzbora() {
		return datumIzbora;
	}

	public void setDatumIzbora(Date datumIzbora) {
		this.datumIzbora = datumIzbora;
	}

	public Date getDatumPrestanka() {
		return datumPrestanka;
	}

	public void setDatumPrestanka(Date datumPrestanka) {
		this.datumPrestanka = datumPrestanka;
	}

	public TipZvanja getTipZvanja() {
		return tipZvanja;
	}

	public void setTipZvanja(TipZvanja tipZvanja) {
		this.tipZvanja = tipZvanja;
	}

	public NaucnaOblast getNaucnaOblast() {
		return naucnaOblast;
	}

	public void setNaucnaOblast(NaucnaOblast naucnaOblast) {
		this.naucnaOblast = naucnaOblast;
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
		if (!(obj instanceof Zvanje)) {
			return false;
		}
		Zvanje other = (Zvanje) obj;
		return Objects.equals(datumIzbora, other.datumIzbora) && Objects.equals(datumPrestanka, other.datumPrestanka)
				&& Objects.equals(id, other.id) && Objects.equals(naucnaOblast, other.naucnaOblast)
				&& Objects.equals(tipZvanja, other.tipZvanja);
	}
	
	

}
