package com.simples.estudantes.pratice;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.simples.estudantes.pratice.dao.EstudanteDAOHibernateImpl;
import com.simples.estudantes.pratice.entity.Estudante;
import com.simples.estudantes.pratice.rest.EstudanteRestController;

@RunWith(SpringRunner.class)

public class EstudanteDAOHibernateTest {
	
////	@Autowired
////	MockMvc mockMvc;
	@Mock
	EstudanteDAOHibernateImpl estudanteDAOHibernateImpl;
	
	@InjectMocks
	EstudanteRestController estudanteRestController;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testarReceberEstudantePorId() {
		Estudante e = new Estudante();
		e.setId(1);
		Mockito.when(estudanteDAOHibernateImpl.findById(1L)).thenReturn(e);
	
		Estudante est1 = estudanteRestController.get(1L);
		
		verify(estudanteDAOHibernateImpl).findById(1);
		
		assertEquals(1, est1.getId().longValue());
		
}
	

}