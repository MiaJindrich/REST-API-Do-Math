package com.firstrestapi.controllers;

import com.firstrestapi.models.ArrayHandler;
import com.firstrestapi.services.LogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ArrayHandlerController {

    private LogServices logServices;

    @Autowired
    public ArrayHandlerController(LogServices logServices) {
        this.logServices = logServices;
    }

    @PostMapping ("/arrays")
    public Map<String, ?> arrayHandler(@RequestBody ArrayHandler arrayHandler) {
        logServices.saveLog("/arrays", "input : " + arrayHandler.getWhat() + "; " + arrayHandler.getNumbers().toString());
        Map<String, String> map = new HashMap<>();
        map.put("error", "Please provide what to do with the numbers!");
        try {
            String action = arrayHandler.getWhat();
            if(action.equals("sum")) {
                Integer result = arrayHandler.sum(arrayHandler.getNumbers());
                Map<String, Integer> map1 = new HashMap<>();
                map1.put("result", result);
                return map1;
            }
            if(action.equals("multiply")) {
                Integer result = arrayHandler.multiply(arrayHandler.getNumbers());
                Map<String, Integer> map2 = new HashMap<>();
                map2.put("result", result);
                return map2;
            }
            if(action.equals("double")) {
                List<Integer> result = arrayHandler.doubleValues(arrayHandler.getNumbers());
                Map<String, List<Integer>> map3 = new HashMap<>();
                map3.put("result", result);
                return map3;
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return map;
    }
}
