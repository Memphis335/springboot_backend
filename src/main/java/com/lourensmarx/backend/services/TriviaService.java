package com.lourensmarx.backend.services;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lourensmarx.backend.model.TriviaResult;

@Service
public class TriviaService {
    private final String ot_api_url = "https://opentdb.com/api.php?amount=5";

    public TriviaResult getQuestions() {
        RestTemplate rTemplate = new RestTemplate();
        
        ResponseEntity<TriviaResult> entities = rTemplate.exchange(ot_api_url, HttpMethod.GET, null, new ParameterizedTypeReference<TriviaResult>() {});
        TriviaResult tResult = entities.getBody();
        return tResult;
    }
}
