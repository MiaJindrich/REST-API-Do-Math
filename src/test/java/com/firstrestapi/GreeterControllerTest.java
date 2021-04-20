package com.firstrestapi;

import com.firstrestapi.controllers.GreeterController;
import com.firstrestapi.services.LogServices;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(GreeterController.class)
class GreeterControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LogServices logServices;

    @Test
    public void greeter_successful() throws Exception {
        mockMvc.perform(get("/greeter?name=Vader&title=Sith"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.welcome_message", is("Oh, hi there Vader, my dear Sith!")));
    }

    @Test
    public void greeter_nameMissing() throws Exception {
        mockMvc.perform(get("/greeter?title=Sith"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", is("Please provide a name!")));
    }

    @Test
    public void greeter_titleMissing() throws Exception {
        mockMvc.perform(get("/greeter?name=Vader"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", is("Please provide a title!")));
    }

    @Test
    public void greeter_unsuccessful() throws Exception {
        mockMvc.perform(get("/greeter"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", is("Please provide a name and a title!")));
    }

}
