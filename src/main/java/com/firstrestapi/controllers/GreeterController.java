package com.firstrestapi.controllers;

import com.firstrestapi.models.Greeter;
import com.firstrestapi.services.LogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GreeterController {

    private LogServices logServices;

    @Autowired
    public GreeterController(LogServices logServices) {
        this.logServices = logServices;
    }

    @GetMapping("/greeter")
    public Map<String, String> getGreeting(@RequestParam(required = false) String name, @RequestParam(required = false) String title, HttpServletResponse response) {
        logServices.saveLog("/greeter", "input : " + name + "; " + title);
        Map<String, String> map = new HashMap<>();

        if(name == null && title == null) {
            Greeter greeter = new Greeter();
            map.put("error", greeter.getError());
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        else if (title == null) {
            map.put("error", "Please provide a title!");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        else if (name == null) {
            map.put("error", "Please provide a name!");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        else {
            Greeter greeter = new Greeter(name, title);
            map.put("welcome_message", greeter.getGreeting());
        }

        return map;
    }
}
