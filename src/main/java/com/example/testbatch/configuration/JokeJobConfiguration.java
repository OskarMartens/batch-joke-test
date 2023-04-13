package com.example.testbatch.configuration;

import com.example.testbatch.entity.Joke;
import com.example.testbatch.processor.JokeProcessor;
import com.example.testbatch.service.JokeService;
import com.example.testbatch.writer.JokeWriter;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
@EnableBatchProcessing
public class JokeJobConfiguration {

    private final JokeService jokeService;

    private final JokeProcessor jokeProcessor;

    private final JokeWriter jokeWriter;

    @Autowired
    public JokeJobConfiguration(
            JokeService jokeService,
            JokeProcessor jokeProcessor,
            JokeWriter jokeWriter) {
        this.jokeService = jokeService;
        this.jokeProcessor = jokeProcessor;
        this.jokeWriter = jokeWriter;
    }

    @Scheduled(cron = "0/15 * * * * ?")
    public void runJokeJob() throws JsonProcessingException {
        System.out.println("Fetching jokes...");
        List<Joke> jokes = jokeService.getJokes();
        System.out.printf("Fetched %d jokes%n", jokes.size());
        for (Joke joke : jokes) {
            if (joke.getType().equals("twopart")) {
                System.out.println(joke.getSetup());
                System.out.println(joke.getDelivery());
            } else {
                System.out.println(joke.getJoke());
            }
            System.out.println("Category: " + joke.getCategory() + "\n");
        }
        System.out.println("Done.");
    }
}
