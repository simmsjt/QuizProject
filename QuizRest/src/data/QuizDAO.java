package data;


import java.util.List;
import java.util.Set;

import entities.Question;
import entities.Quiz;

public interface QuizDAO {
	List<Quiz> getQuizzes();
	Quiz getQuizById(int id);
	Quiz updateQuiz(String json, int id);
	Boolean deleteQuiz(int id);
	Quiz createQuiz(String json);
	Set<Question> getQuestions(int id);
	Question addQuestion(String json, int id);
	Boolean deleteQuestion(int id);
}
