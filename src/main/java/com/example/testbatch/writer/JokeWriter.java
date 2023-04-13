package com.example.testbatch.writer;


import com.example.testbatch.entity.Joke;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JokeWriter {

    public void write(List<? extends Joke> jokes) {
        jokes.forEach(joke -> System.out.println(joke));
    }
}
