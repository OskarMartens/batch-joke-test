package com.example.testbatch.response;

import com.example.testbatch.entity.Joke;

import java.util.List;

public class MyResponse {
    private List<Joke> jokes;

    public List<Joke> getJokes() {
        return jokes;
    }

    public void setJokes(List<Joke> jokes) {
        this.jokes = jokes;
    }
}
