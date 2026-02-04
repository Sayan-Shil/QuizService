package com.sayan.micro.quizservice.services;

import com.sayan.micro.quizservice.entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8081",value = "Question-Quiz")
public interface QuestionClient {

    @GetMapping("/api/question/quiz/{id}")
    List<Question> getQuestionsOfQuiz(@PathVariable String id);
}
