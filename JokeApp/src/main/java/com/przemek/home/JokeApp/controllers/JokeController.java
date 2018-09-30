package com.przemek.home.JokeApp.controllers;

import com.przemek.home.JokeApp.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JokeController {

    private JokeService jokeService;

    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping({"/", ""})
    String showRandomJoke(Model model) {
        model.addAttribute("joke", jokeService.getRandomJoke());
        return "jokes";
    }
}
