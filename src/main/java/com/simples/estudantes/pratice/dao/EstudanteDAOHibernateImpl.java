package com.simples.estudantes.pratice.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.simples.estudantes.pratice.entity.Estudante;

@Repository
public class EstudanteDAOHibernateImpl implements EstudanteDAO {
	
	//Definir o campo para entityManager
	private EntityManager entityManager;
	
	
	//Fazer a configuração da injeção (construtor ou outro)
	@Autowired
	public EstudanteDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Estudante> findAll() {
		
		//receber a session hibernate atual
		Session currentSession = entityManager.unwrap(Session.class);
		
		//criar a query
		Query<Estudante> theQuery =
				currentSession.createQuery("from Estudante", Estudante.class);
		
		//executar query e receber a lista de resultado
		List<Estudante> estudantes = theQuery.getResultList();
		
		//retornar os resultados
		return estudantes;
	}

	@Override
	public Estudante findById(int theId) {
		
		//receber a session hibernate atual
		Session currentSession = entityManager.unwrap(Session.class);
		
		//receber um Estudante
		Estudante theEstudante =
				currentSession.get(Estudante.class, theId);
		
		//Retorna Estudante
		
		return theEstudante;
	}

	@Override
	public void save(Estudante theEstudante) {
		
		//receber a session hibernate atual
		Session currentSession = entityManager.unwrap(Session.class);
		
		//salvar ou atualizar um Estudante
		currentSession.saveOrUpdate(theEstudante);
		
	}

	@Override
	public void delete(int theId) {
		//receber a session hibernate atual
		Session currentSession = entityManager.unwrap(Session.class);
		
		//deletando um objeto pela sua PK
		Query theQuery =
				currentSession.createQuery("delete from Estudante where id=:estudanteId");
		theQuery.setParameter("estudanteId", theId);
		
		theQuery.executeUpdate();
		
	}

	

}
