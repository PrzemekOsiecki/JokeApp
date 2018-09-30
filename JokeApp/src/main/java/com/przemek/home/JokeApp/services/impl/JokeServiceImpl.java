package com.przemek.home.JokeApp.services.impl;

import com.przemek.home.JokeApp.services.JokeService;
import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JokeServiceImpl implements JokeService {

    private final ChuckNorrisQuotes chuckNorrisQuotes;

    JokeServiceImpl() {
        this.chuckNorrisQuotes = new ChuckNorrisQuotes();
    }

    @Override

    public String getRandomJoke() {
        return chuckNorrisQuotes.getRandomQuote();
    }
}
