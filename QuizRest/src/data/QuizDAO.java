package data;


import java.util.List;

import entities.Quiz;

public interface QuizDAO {
	List<Quiz> getQuizzes();
	Quiz getQuizById(int id);
	Quiz updateQuiz(String json, int id);
	Boolean deleteQuiz(int id);
	Quiz createQuiz(String json);
}
