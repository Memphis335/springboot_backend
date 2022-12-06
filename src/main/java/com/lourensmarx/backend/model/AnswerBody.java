package com.lourensmarx.backend.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnswerBody {
    @JsonProperty(value="id")
    private UUID qID;
    @JsonProperty(value="answer")
    private String answer;

    public UUID getQuestionID() {
        return qID;
    }
    public void setQuestionID(UUID qID) {
        this.qID = qID;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
