package io.github.sudhansubarik.javajoker;

import java.util.Random;

public class Joker {
    public String[] jokes;
    private Random random;

    public Joker() {
        jokes = new String[4];
        jokes[0] = "There are 10 types of people in the world: those who understand binary, and those who don't.";
        jokes[1] = "Why do Java developers wear glasses? Because they can't C#";
        jokes[2] = "Microsoft gives you Windows, Linux gives you a home!";
        jokes[3] = "Why did the developer go broke? Because he used up all his cache";
        random = new Random();
    }

    public String[] getJokes() {
        return jokes;
    }

    public String getRandomJoke() {
        return jokes[random.nextInt(jokes.length)];
    }
}
