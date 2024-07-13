package com.quiz.service;

import java.util.List;

import com.quiz.entity.Quiz;

public interface QuizService {

	Quiz addQuiz(Quiz quiz);
	
	List<Quiz> getAllQuiz();
	
	Quiz getQuiz(Long id);
}
