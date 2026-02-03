package com.sayan.micro.quizservice.services;

import com.sayan.micro.quizservice.entities.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;

public interface QuizService {

    Quiz addQuiz(Quiz quiz);
    List<Quiz> getQuizes();
    Quiz getQuiz(Long id);

}
