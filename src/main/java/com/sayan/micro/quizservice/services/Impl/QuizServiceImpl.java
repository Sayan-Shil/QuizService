package com.sayan.micro.quizservice.services.Impl;

import com.sayan.micro.quizservice.entities.Quiz;
import com.sayan.micro.quizservice.repository.QuizRepository;
import com.sayan.micro.quizservice.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getQuizes() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz getQuiz(Long id) {
        return quizRepository.findById(id).orElseThrow(()->new RuntimeException("Not Quiz"));
    }
}
