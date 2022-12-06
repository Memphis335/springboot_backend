package com.lourensmarx.backend.model;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "type",
    "difficulty",
    "category",
    "question"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {
    @JsonInclude
    @JsonProperty(value="id")
    @JsonView(Views.Public.class)
    private UUID id;
    @JsonInclude
    @JsonView(Views.Public.class)
    private List<String> possibleAnswers;
    @JsonView(Views.Public.class)
    @JsonProperty("category")
    private String category;
    @JsonView(Views.Public.class)
    @JsonProperty("type")
    private String type;
    @JsonView(Views.Public.class)
    @JsonProperty("difficulty")
    private String difficulty;
    @JsonView(Views.Public.class)
    @JsonProperty("question")
    private String question;
    @JsonView(Views.Private.class)
    @JsonProperty("correct_answer")
    private String correctAnswer;
    @JsonView(Views.Private.class)
    @JsonProperty("incorrect_answers")
    private List<String> incorrectAnswers;

    @JsonProperty(value="id")
    public UUID getId() {
        return id;
    }

    @JsonProperty(value="id")
    public void setId(UUID id) {
        this.id = id;
    }
    
    @JsonProperty("category")
    public String getCategory() {
        return category;
    }
    
    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }
    
    @JsonProperty("type")
    public String getType() {
        return type;
    }
    
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }
    
    @JsonProperty("difficulty")
    public String getDifficulty() {
        return difficulty;
    }
    
    @JsonProperty("difficulty")
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    
    @JsonProperty("question")
    public String getQuestion() {
        return question;
    }
    
    @JsonProperty("question")
    public void setQuestion(String question) {
        this.question = question;
    }
    
    @JsonProperty("correct_answer")
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    
    @JsonProperty("correct_answer")
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    
    @JsonProperty("incorrect_answers")
    public List<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }
    
    @JsonProperty("incorrect_answers")
    public void setIncorrectAnswers(List<String> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }

    @JsonFormat
    public void setPossibleAnswers(List<String> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }
}
