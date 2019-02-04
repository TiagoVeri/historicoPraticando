package com.simples.estudantes.pratice.dao;

import java.util.List;

import com.simples.estudantes.pratice.entity.Estudante;

public interface EstudanteDAO {
	
	//Receber lista de estudantes
	public List<Estudante> findAll();
	
	//Receber estudante por id
	public Estudante findById(int theId);
	
	//Salvar um estudante ou atualizar um existente
	public void save(Estudante theEstudante);
	
	//deletar um estudante
	public void delete(int theId);
	
	
}
