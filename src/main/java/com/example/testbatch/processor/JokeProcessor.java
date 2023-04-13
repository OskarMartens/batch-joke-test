package com.example.testbatch.processor;

import com.example.testbatch.entity.Joke;
import org.springframework.stereotype.Component;

@Component
public class JokeProcessor {

    public Joke process(Joke joke) {
        joke.setCategory(null);
        return joke;
    }
}
