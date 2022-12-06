package com.lourensmarx.backend.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.lourensmarx.backend.model.*;
import com.lourensmarx.backend.repository.QuestionsRepository;

@RestController
@CrossOrigin
public class QuestionsController {

    private final QuestionsRepository repository;

    public QuestionsController(QuestionsRepository repository) {
        this.repository = repository;
    }

    @JsonView(Views.Public.class)
    @GetMapping("/questions")
    public List<Question> GetQuestions() {
       return this.repository.getAll();
    }

    @JsonView(Views.Public.class)
    @GetMapping("/questions/{id}")
    public Question findQuestion(@PathVariable UUID id) {
        return repository.getQuestion(id);
    }

    // @PostMapping("/checkanswer")
    // @JsonView(Views.Public.class)
    // public Boolean answerCorrect(@RequestParam("ID") UUID id, @PathParam("answer") String answer) {
    //     return repository.checkAnswer(id, answer);
    // }

    @JsonView(Views.Public.class)
    @PostMapping("/checkanswers")
    public List<AnswerResult> answerCorrect(@RequestBody List<AnswerBody> answers) {
        return repository.checkAnswers(answers);
    }
}
