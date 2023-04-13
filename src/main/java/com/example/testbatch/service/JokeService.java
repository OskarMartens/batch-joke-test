package com.example.testbatch.service;

import com.example.testbatch.entity.Joke;
import com.example.testbatch.response.MyResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class JokeService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public JokeService(
            RestTemplateBuilder restTemplateBuilder,
            ObjectMapper objectMapper) {
        this.restTemplate = restTemplateBuilder.build();
        this.objectMapper = objectMapper;
    }

    public List<Joke> getJokes() throws JsonProcessingException {
        String url = "https://v2.jokeapi.dev/joke/Any?amount=5";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String responseBody = response.getBody();
        MyResponse myResponse = objectMapper.readValue(responseBody, MyResponse.class);
        return myResponse.getJokes();
    }
}
