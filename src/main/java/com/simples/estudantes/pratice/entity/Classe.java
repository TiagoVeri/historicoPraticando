package com.simples.estudantes.pratice.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="classe")
public class Classe implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="turma")
	private String turma;
	
	@Column(name="periodo")
	private String periodo;
	
	@Column(name="capacidade")
	private int capacidadeAlunos;
	
	@Column(name="ensino")
	private String ensino;
	
	//Lista de alunos para relacionar em que classe (serie) estarão
	@OneToMany(mappedBy="classe")
	private List<Estudante> estudantes = new ArrayList<>();
	
	public Classe() {
		
	}
	
	
	
	public Classe(String turma, String periodo, int capacidadeAlunos, String ensino) {
		this.turma = turma;
		this.periodo = periodo;
		this.capacidadeAlunos = capacidadeAlunos;
		this.ensino = ensino;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public int getCapacidadeAlunos() {
		return capacidadeAlunos;
	}

	public void setCapacidadeAlunos(int capacidadeAlunos) {
		this.capacidadeAlunos = capacidadeAlunos;
	}

	public String getEnsino() {
		return ensino;
	}

	public void setEnsino(String ensino) {
		this.ensino = ensino;
	}



	public List<Estudante> getEstudantes() {
		return estudantes;
	}



	public void setEstudantes(List<Estudante> estudantes) {
		this.estudantes = estudantes;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Classe other = (Classe) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
