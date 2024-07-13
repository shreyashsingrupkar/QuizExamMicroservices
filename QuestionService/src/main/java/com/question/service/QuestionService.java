package com.question.service;

import java.util.List;

import com.question.entity.Question;

public interface QuestionService {

	Question addQuestion(Question question);
	
	List<Question> getAllQuestion();
	
	Question getQuestion(Long id);
	
	List<Question> getQuestionOfQuiz(Long quizId);
}
