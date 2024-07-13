package com.quiz.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entity.Quiz;
import com.quiz.repository.QuizRepository;
import com.quiz.service.QuestionClient;
import com.quiz.service.QuizService;
@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private QuestionClient questionClient;
	
	@Override
	public Quiz addQuiz(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> getAllQuiz() {
		
		List<Quiz> quizs = quizRepository.findAll();
		
		List<Quiz> newQuizList = quizs.stream().map(quiz ->{
			quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		
		return newQuizList;
	}

	@Override
	public Quiz getQuiz(Long id) {
		
		Quiz quiz=quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz Not Found"));
		quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
		return quiz;
	}

}
