package com.firstrestapi.controllers;

import com.firstrestapi.models.DoUntil;
import com.firstrestapi.services.LogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DoUntilController {

    private LogServices logServices;
    @Autowired
    public DoUntilController(LogServices logServices) {
        this.logServices = logServices;
    }

    @PostMapping("/dountil/{action}")
    public Map<String, ?> doUntil(@PathVariable String action, @RequestBody Map<String, Integer> request, HttpServletResponse response) {
        DoUntil numbers = new DoUntil();
        try {
            Integer input = request.get("until");
            logServices.saveLog("/dountil/" + action, "input : " + action + "; " + input);
            if(action.equals("sum")){
                Map<String, Integer> map1 = new HashMap<>();
                map1.put("result", numbers.sum(input));

                return map1;
            }
            if(action.equals("factor")){
                Map<String, Integer> map2 = new HashMap<>();
                map2.put("result", numbers.factor(input));
                return map2;
            }

        } catch(Exception e) {
            e.getStackTrace();
        }

        Map<String, String> map = new HashMap<>();
        map.put("error", "Please provide a number!");
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return map;
    }
}
