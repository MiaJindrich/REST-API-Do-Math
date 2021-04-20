package com.firstrestapi;

import com.firstrestapi.controllers.DoublingController;
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
@WebMvcTest(DoublingController.class)
class DoublingControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LogServices logServices;

    @Test
    public void doubling_successful() throws Exception {
        mockMvc.perform(get("/doubling?input=5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.received", is(5)))
                .andExpect(jsonPath("$.result", is(10)));
    }

    @Test
    public void doubling_unsuccessful() throws Exception {
        mockMvc.perform(get("/doubling"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", is("Please provide an input!")));
    }

}
