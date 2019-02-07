package com.simples.estudantes.pratice.dao;

import java.util.List;

import com.simples.estudantes.pratice.entity.Classe;
import com.simples.estudantes.pratice.entity.Estudante;

public interface ClasseDAO {
	
		//Receber lista de classes
		public List<Classe> findAll();
		
		//Receber classes por id
		public Classe findById(long theId);
		
		//Salvar um classes ou atualizar um existente
		public void save(Classe theClasse);
		
		//deletar um classe
		public void delete(int theId);
	
}
