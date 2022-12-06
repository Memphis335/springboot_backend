package com.lourensmarx.backend.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.lourensmarx.backend.model.AnswerBody;
import com.lourensmarx.backend.model.AnswerResult;
import com.lourensmarx.backend.model.Question;
import com.lourensmarx.backend.model.TriviaResult;
import com.lourensmarx.backend.services.TriviaService;

@Repository
public class QuestionsRepository {
    private final TriviaService triviaService;
    public TriviaResult triviaResult;
    
    public QuestionsRepository(TriviaService triviaService) {
        this.triviaService = triviaService;
    }
    
    public List<Question> getAll(){
        try {
            triviaResult = triviaService.getQuestions();

            for (Question question : triviaResult.results()) {
                List<String> possibleAnswers = new ArrayList<>();

                question.setId(UUID.randomUUID());
                possibleAnswers.add(question.getCorrectAnswer());
                possibleAnswers.addAll(question.getIncorrectAnswers());
                Collections.shuffle(possibleAnswers);
                question.setPossibleAnswers(possibleAnswers);
            }
            
            return triviaResult.results();
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public Question getQuestion(UUID id) {
        return triviaResult.results().stream().filter(question -> question.getId().equals(id)).findFirst().orElseThrow(() -> new IllegalArgumentException("Question not found"));
    }

    public Boolean checkAnswer(UUID id, String answer) {
        Question q = triviaResult.results().stream().filter(question -> question.getId().equals(id)).findFirst().orElseThrow(() -> new IllegalArgumentException("Question not found"));
        return q.getCorrectAnswer().equals(answer);
    }

    public List<AnswerResult> checkAnswers(List<AnswerBody> answers) {
        List<AnswerResult> resultsList = new ArrayList<>();
        for (AnswerBody answer : answers) {
            Question q = triviaResult.results().stream().filter(question -> question.getId().equals(answer.getQuestionID())).findFirst().orElseThrow(() -> new IllegalArgumentException("Question not found"));
            resultsList.add(new AnswerResult(answer.getQuestionID(),q.getCorrectAnswer().equals(answer.getAnswer())));
        }
        return resultsList;
    }
}
