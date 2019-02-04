package com.simples.estudantes.pratice.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simples.estudantes.pratice.entity.Estudante;
import com.simples.estudantes.pratice.service.EstudanteService;

@RestController
@RequestMapping("/api")
public class EstudanteRestController {

	
	private EstudanteService estudanteService;
	
	//para rodar por enquanto.
	@Autowired
	public EstudanteRestController(EstudanteService theEstudanteService) {
		estudanteService = theEstudanteService;
	}
	
	//retornar lista de Estudante
	@GetMapping("/estudante")
	public List<Estudante> findAll(){
		return estudanteService.findAll();
	}
	
	//retornar Estudante pelo seu ID
	@GetMapping("/estudante/{estudanteId}")
	public Estudante getEstudante(@PathVariable int estudanteId) {
		
		Estudante theEstudante = estudanteService.findById(estudanteId);
		
		if(theEstudante == null) {
			throw new RuntimeException("Estudante não encontrado: " + estudanteId);
		}
		
		return theEstudante;
		
	}
	
	//adicionar um Estudante
	@PostMapping("/estudante")
	public Estudante addEstudante(@RequestBody Estudante theEstudante) {
		
		//Caso for passado um id em json
		theEstudante.setId(0);
		
		estudanteService.save(theEstudante);
		
		return theEstudante;
		
	}
	
	//Atualizar um Estudante
	@PutMapping("/estudante")
		public Estudante updateEstudante(@RequestBody Estudante theEstudante) {
			
			estudanteService.save(theEstudante);
			
			return theEstudante;
			
		}
	//Deletar um estudante
	@DeleteMapping("/estudante/{estudanteId}")
	public String deleteEstudante(@PathVariable int estudanteId) {
		
		Estudante tempEstudante = estudanteService.findById(estudanteId);
		
		//lançar exception se null
		
		if(tempEstudante == null) {
			throw new RuntimeException("Não foi encontrado Id: " + estudanteId);
		}
		
		estudanteService.delete(estudanteId);
		
		return "Deletado estudante do id: " + estudanteId;
				
				
	}
	
	
}
