package com.simples.estudantes.pratice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simples.estudantes.pratice.dao.EstudanteDAO;
import com.simples.estudantes.pratice.entity.Estudante;

@Service
public class EstudanteServiceImpl implements EstudanteService {
	
	private EstudanteDAO estudanteDAO;
	
	@Autowired
	
	public EstudanteServiceImpl(EstudanteDAO theEstudanteDAO) {
		estudanteDAO = theEstudanteDAO;
	}
	
	@Override
	@Transactional
	public List<Estudante> findAll() {
		return estudanteDAO.findAll();
		
	}



	@Override
	@Transactional
	public Estudante findById(int theId) {
		return estudanteDAO.findById(theId);
		 
	}

	@Override
	@Transactional
	public void save(Estudante theEstudante) {
		estudanteDAO.save(theEstudante);

	}

	@Override
	@Transactional
	public void delete(int theId) {
		estudanteDAO.delete(theId);

	}

}
