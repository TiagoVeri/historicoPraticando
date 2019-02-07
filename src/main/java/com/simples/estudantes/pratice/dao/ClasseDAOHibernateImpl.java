package com.simples.estudantes.pratice.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simples.estudantes.pratice.entity.Classe;

@Repository
public class ClasseDAOHibernateImpl implements ClasseDAO {
	
	private EntityManager entityManager;
	
	
	@Autowired
	public ClasseDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Classe> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Classe> theQuery =
				currentSession.createQuery("From Classe", Classe.class);
		
		List<Classe> classes = theQuery.getResultList();		
		
			
		return classes;
	}

	

	@Override
	public Classe findById(long theId) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Classe theClasse =
				currentSession.get(Classe.class, theId);
		
		return theClasse;
	}

	@Override
	public void save(Classe theClasse) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theClasse);

	}

	@Override
	public void delete(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery =
				currentSession.createQuery("delete from Classe where id=:classeId");
		
		theQuery.setParameter("classeId", theId);
		theQuery.executeUpdate();

	}

}
