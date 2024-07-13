package com.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.entity.Question;
import com.question.repository.QuestionRepository;
import com.question.service.QuestionService;
@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public Question addQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public List<Question> getAllQuestion() {
		return questionRepository.findAll();
	}

	@Override
	public Question getQuestion(Long id) {
		return questionRepository.findById(id).orElseThrow(()->new RuntimeException("Question Not Found")) ;
	}

	@Override
	public List<Question> getQuestionOfQuiz(Long quizId) {
		return questionRepository.findByQuizId(quizId);
	}

}
