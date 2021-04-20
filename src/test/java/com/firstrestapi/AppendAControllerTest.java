package com.firstrestapi;

import com.firstrestapi.controllers.AppendAController;
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
@WebMvcTest(AppendAController.class)
class AppendAControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LogServices logServices;

    @Test
    public void appendA_successful() throws Exception {
        mockMvc.perform(get("/appenda/kuty"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.appended", is("kutya")));
    }

    @Test
    public void appendA_unsuccessful() throws Exception {
        mockMvc.perform(get("/appenda/"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", is("Please provide a variable!")));
    }

}
