package com.lourensmarx.backend.model;

import java.util.List;

public record TriviaResult(Integer responseCode, List<Question> results) {
}
