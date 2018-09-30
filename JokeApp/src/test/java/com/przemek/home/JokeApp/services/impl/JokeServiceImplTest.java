package com.przemek.home.JokeApp.services.impl;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.junit.Assert;
import org.junit.Test;

public class JokeServiceImplTest {

    JokeServiceImpl uut = new JokeServiceImpl(new ChuckNorrisQuotes());

    @Test
    public void test() {
        String result = uut.getRandomJoke();

        Assert.assertNotNull(result);
    }

}