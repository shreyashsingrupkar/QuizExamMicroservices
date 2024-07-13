package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entity.Quiz;
import com.quiz.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping
	public Quiz addQuiz(@RequestBody Quiz quiz) {
		return quizService.addQuiz(quiz);	
	}
	
	@GetMapping
	public List<Quiz> gettAllQuiz(){
		return quizService.getAllQuiz();
	}
	
	@GetMapping("/{id}")
	public Quiz getQuiz(@PathVariable Long id) {
		return quizService.getQuiz(id);
	}
	
}
