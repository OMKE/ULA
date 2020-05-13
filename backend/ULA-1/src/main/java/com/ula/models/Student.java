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
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Type(type = "text")
	private String jmbg;

	@Column
	@Type(type = "text")
	private String ime;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<StudentNaGodini> studentNaGodini= new ArrayList<>();;

	@ManyToOne(optional = false)
	private Adresa adresa;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<PohadjanjePredmeta> pohadjanjePredmeta = new ArrayList<>();

	public Student() {
		super();
	}

	public Student(Long id, String jmbg, String ime, List<StudentNaGodini> studentNaGodini, Adresa adresa,
			List<PohadjanjePredmeta> pohadjanjePredmeta) {
		super();
		this.id = id;
		this.jmbg = jmbg;
		this.ime = ime;
		this.studentNaGodini = studentNaGodini;
		this.adresa = adresa;
		this.pohadjanjePredmeta = pohadjanjePredmeta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public List<StudentNaGodini> getStudentNaGodini() {
		return studentNaGodini;
	}

	public void setStudentNaGodini(List<StudentNaGodini> studentNaGodini) {
		this.studentNaGodini = studentNaGodini;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public List<PohadjanjePredmeta> getPohadjanjePredmeta() {
		return pohadjanjePredmeta;
	}

	public void setPohadjanjePredmeta(List<PohadjanjePredmeta> pohadjanjePredmeta) {
		this.pohadjanjePredmeta = pohadjanjePredmeta;
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
		if (!(obj instanceof Student)) {
			return false;
		}
		Student other = (Student) obj;
		return Objects.equals(adresa, other.adresa) && Objects.equals(id, other.id) && Objects.equals(ime, other.ime)
				&& Objects.equals(jmbg, other.jmbg) && Objects.equals(pohadjanjePredmeta, other.pohadjanjePredmeta)
				&& Objects.equals(studentNaGodini, other.studentNaGodini);
	}
	
	


	}

	

