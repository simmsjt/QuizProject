package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Quiz;

public class QuizTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	private Quiz q;
	
	@Before
	public void set_up() { 
		this.emf = Persistence.createEntityManagerFactory("YourPU");
		this.em = emf.createEntityManager();
		this.q = em.find(Quiz.class, 1);
	}
	
	@After
	public void tear_down() { }
	
	@Test
	public void quiz_test() {
		boolean test = true;
		assertEquals(true, test);
	}
	
	@Test
	public void query_test() {
		assertEquals("What kind of cake are you?",q.getName());
	}
	
	@Test
	public void query_test_questions() {
		assertEquals(2,q.getQuestions().size());
	}
	
}
