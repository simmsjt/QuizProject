package controllers;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.QuizDAO;
import entities.Question;
import entities.Quiz;

@RestController
public class QuizController {
	
	@Autowired
	QuizDAO dao;
	
	
	@RequestMapping(path="ping", method=RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	
	@RequestMapping(path="quizzes", method=RequestMethod.GET)
	public List<Quiz> getQuizzes(){
		return dao.getQuizzes();
	}
	
	@RequestMapping(path="quizzes/{id}", method=RequestMethod.GET)
	public Quiz show(@PathVariable int id) {
		return dao.getQuizById(id);
	}
	
	@RequestMapping(path="quizzes", method=RequestMethod.POST)
	public Quiz create(@RequestBody String json, HttpServletResponse res) {
		Quiz a = dao.createQuiz(json);
		if(a==null) {
			res.setStatus(400);
		}else {
			res.setStatus(201);
		}
		return a;
	}
	
	@RequestMapping(path="quizzes/{id}", method=RequestMethod.PUT)
	public Quiz update(@RequestBody String json, @PathVariable int id) {
		Quiz a = dao.updateQuiz(json,id);
		return a;
	}
	
	
	@RequestMapping(path="quizzes/{id}", method=RequestMethod.DELETE)
	public Boolean update(@PathVariable int id) {
		Boolean a = dao.deleteQuiz(id);
		return a;
	}
	
	@RequestMapping(path="quizzes/{id}/questions", method=RequestMethod.GET)
	public Set<Question> addQuestion(@PathVariable int id) {
		Set<Question> q = dao.getQuestions(id);
		return q;
	}
	
	@RequestMapping(path="quizzes/{id}/questions", method=RequestMethod.POST)
	public Question addQuestion(@RequestBody String json, @PathVariable int id) {
		Question q = dao.addQuestion(json, id);
		return q;
	}
	
	@RequestMapping(path="quizzes/{id}/questions/{qid}", method=RequestMethod.DELETE)
	public Boolean deleteQuestion(@PathVariable int id, @PathVariable int qid) {
		Boolean q = dao.deleteQuestion(qid);
		return q;
	}
	
	
}
