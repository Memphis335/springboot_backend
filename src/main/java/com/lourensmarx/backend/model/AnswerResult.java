package com.lourensmarx.backend.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonView;

public class AnswerResult {
    @JsonView(Views.Public.class)
    private UUID id;
    @JsonView(Views.Public.class)
    private Boolean answerResult;
    
    public AnswerResult(UUID qUuid, Boolean answerResult) {
        this.id = qUuid;
        this.answerResult = answerResult;
    }
    public UUID getqUuid() {
        return id;
    }
    public void setqUuid(UUID qUuid) {
        this.id = qUuid;
    }
    public Boolean getAnswerResult() {
        return answerResult;
    }
    public void setAnswerResult(Boolean answerResult) {
        this.answerResult = answerResult;
    }
}
