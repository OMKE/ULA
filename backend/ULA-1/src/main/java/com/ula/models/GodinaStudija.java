package com.ula.models;

import java.util.Date;
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
@Table(name = "godinaStudija")
public class GodinaStudija {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Type(type = "date")
	private Date godina;

	@ManyToOne(optional = false)
	private Predmet predmet;
	
	@ManyToMany
	private StudijskiProgram studijskiProgram;
	
	

	public GodinaStudija() {
		super();
		// TODO Auto-generated constructor stub
	}



	public GodinaStudija(Long id, Date godina, Predmet predmet, StudijskiProgram studijskiProgram) {
		super();
		this.id = id;
		this.godina = godina;
		this.predmet = predmet;
		this.studijskiProgram = studijskiProgram;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Date getGodina() {
		return godina;
	}



	public void setGodina(Date godina) {
		this.godina = godina;
	}



	public Predmet getPredmet() {
		return predmet;
	}



	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}



	public StudijskiProgram getStudijskiProgram() {
		return studijskiProgram;
	}



	public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
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
		if (!(obj instanceof GodinaStudija)) {
			return false;
		}
		GodinaStudija other = (GodinaStudija) obj;
		return Objects.equals(godina, other.godina) && Objects.equals(id, other.id)
				&& Objects.equals(predmet, other.predmet) && Objects.equals(studijskiProgram, other.studijskiProgram);
	}



}
