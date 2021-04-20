package com.firstrestapi.controllers;

import com.firstrestapi.services.LogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AppendAController {

    private LogServices logServices;

    @Autowired
    public AppendAController(LogServices logServices) {
        this.logServices = logServices;
    }

    @GetMapping("/appenda/{appendable}")
    public Map<String,String> appendA(@PathVariable String appendable) {
        Map<String,String> map = new HashMap<>();
        map.put("appended", appendable + "a");
        logServices.saveLog("/appenda/" + appendable, "input : " + appendable);
        return map;
    }

    @GetMapping("/appenda/")
    public Map<String, String> appendUnsuccessfully(HttpServletResponse response) {
        Map<String,String> map = new HashMap<>();
        map.put("error", "Please provide a variable!");
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return map;
    }

}
