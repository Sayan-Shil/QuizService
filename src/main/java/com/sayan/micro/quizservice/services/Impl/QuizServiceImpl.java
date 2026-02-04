package com.sayan.micro.quizservice.services.Impl;

import com.sayan.micro.quizservice.entities.Quiz;
import com.sayan.micro.quizservice.repository.QuizRepository;
import com.sayan.micro.quizservice.services.QuestionClient;
import com.sayan.micro.quizservice.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final QuestionClient questionClient;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getQuizes() {
        List<Quiz> quizzes =  quizRepository.findAll();
        quizzes.forEach(quiz ->
                quiz.setQuestions(
                        questionClient.getQuestionsOfQuiz(String.valueOf(quiz.getId()))
                )
        );

        return quizzes;
    }

    @Override
    public Quiz getQuiz(Long id) {
        return quizRepository.findById(id)
                .map(quiz -> {
                    quiz.setQuestions(
                            questionClient.getQuestionsOfQuiz(String.valueOf(quiz.getId()))
                    );
                    return quiz;
                })
                .orElseThrow(() -> new RuntimeException("No Quiz"));

    }
}
