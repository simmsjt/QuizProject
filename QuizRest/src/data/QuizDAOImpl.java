package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Quiz;

@Transactional
@Repository
public class QuizDAOImpl implements QuizDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Quiz> getQuizzes() {
		String query = "SELECT q FROM Quiz q";
		List<Quiz> quizzes = em.createQuery(query, Quiz.class).getResultList();
		return quizzes;
	}

	@Override
	public Quiz getQuizById(int id) {
		return em.find(Quiz.class, id);
	}

	@Override
	public Quiz createQuiz(String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Quiz newQuiz = mapper.readValue(json, Quiz.class);	
			em.persist(newQuiz);
			em.flush();
			return newQuiz;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Quiz updateQuiz(String json, int id) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Quiz newQuiz = mapper.readValue(json, Quiz.class);	
			Quiz oldQuiz = em.find(Quiz.class, id);
			oldQuiz.setName(newQuiz.getName());
			em.persist(oldQuiz);
			return newQuiz;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean deleteQuiz(int id) {
		try {
			em.remove(getQuizById(id));
			return true;
		} catch(Exception e) {
			return false;
		}
	}

}
