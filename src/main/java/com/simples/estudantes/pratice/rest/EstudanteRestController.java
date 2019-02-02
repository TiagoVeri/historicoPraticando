package com.simples.estudantes.pratice.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simples.estudantes.pratice.dao.EstudanteDAO;
import com.simples.estudantes.pratice.entity.Estudante;

@RestController
@RequestMapping("/api")
public class EstudanteRestController {

	
	private EstudanteDAO estudanteDAO;
	
	//para rodar por enquanto.
	@Autowired
	public EstudanteRestController(EstudanteDAO theEstudanteDAO) {
		estudanteDAO = theEstudanteDAO;
	}
	
	//retornar lista de Alunos
	@GetMapping("/estudante")
	public List<Estudante> findAll(){
		return estudanteDAO.findAll();
	}
	
}
