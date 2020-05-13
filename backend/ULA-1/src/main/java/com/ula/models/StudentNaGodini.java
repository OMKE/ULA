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
@Table(name = "studentNaGodini")

public class StudentNaGodini {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Type(type = "date")
	private Date datumUpisa;

	@Column
	@Type(type = "string")
	private String brojIndeksa;

	@ManyToOne(optional= false)
	private Student student;

	@ManyToOne(optional = false)
	private GodinaStudija godinaStudija;

	public StudentNaGodini() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentNaGodini(Long id, Date datumUpisa, String brojIndeksa, Student student, GodinaStudija godinaStudija) {
		super();
		this.id = id;
		this.datumUpisa = datumUpisa;
		this.brojIndeksa = brojIndeksa;
		this.student = student;
		this.godinaStudija = godinaStudija;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatumUpisa() {
		return datumUpisa;
	}

	public void setDatumUpisa(Date datumUpisa) {
		this.datumUpisa = datumUpisa;
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public GodinaStudija getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(GodinaStudija godinaStudija) {
		this.godinaStudija = godinaStudija;
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
		if (!(obj instanceof StudentNaGodini)) {
			return false;
		}
		StudentNaGodini other = (StudentNaGodini) obj;
		return Objects.equals(brojIndeksa, other.brojIndeksa) && Objects.equals(datumUpisa, other.datumUpisa)
				&& Objects.equals(id, other.id) && Objects.equals(student, other.student);
	}

	
	
}
