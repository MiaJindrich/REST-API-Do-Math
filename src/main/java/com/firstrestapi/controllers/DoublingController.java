package com.firstrestapi.controllers;

import com.firstrestapi.models.Doubling;
import com.firstrestapi.services.LogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DoublingController {

    private LogServices logServices;

    @Autowired
    public DoublingController(LogServices logServices) {
        this.logServices = logServices;
    }

    @GetMapping("/doubling")
    public Map<String, ?> doubling(@RequestParam(required = false) Integer input, HttpServletResponse response) {
        if(input == null) {
            Doubling doubling = new Doubling();
            Map<String, String> map = new HashMap<>();
            map.put("error", doubling.getError());
            //response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return map;
        }
        Doubling doubling = new Doubling(input);
        Map<String, Integer> map = new HashMap<>();
        map.put("received", doubling.getInput());
        map.put("result", doubling.getResult());
        logServices.saveLog("/doubling", "input : " + input.toString());
        return map;
    }
}
