package com.przemek.home.JokeApp.controllers;

import com.przemek.home.JokeApp.services.JokeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JokeControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Mock
    JokeService jokeServiceMock;

    JokeController uut;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .build();
        uut = new JokeController(jokeServiceMock);
    }

    @Test
    public void test() throws Exception {
        final String JOKE = "joke";

        when(jokeServiceMock.getRandomJoke()).thenReturn(JOKE);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("jokes"));
//        .andExpect(model().attribute("joke", JOKE));
    }
}