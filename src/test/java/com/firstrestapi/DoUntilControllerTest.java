package com.firstrestapi;

import com.firstrestapi.controllers.AppendAController;
import com.firstrestapi.services.LogServices;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AppendAController.class)
class DoUntilControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LogServices logServices;

    @Test
    public void doUntil_sum_successful() throws Exception {
        mockMvc.perform(post("/dountil/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"until\":7}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(28)));
    }

    @Test
    public void doUntil_factor_successful() throws Exception {
        mockMvc.perform(post("/dountil/factor")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"until\":4}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(24)));
    }

}

