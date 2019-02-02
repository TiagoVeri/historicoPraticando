package com.simples.estudantes.pratice.dao;

import java.util.List;

import com.simples.estudantes.pratice.entity.Estudante;

public interface EstudanteDAO {
	
	//Receber lista de estudantes
	public List<Estudante> findAll();
	
	
}
