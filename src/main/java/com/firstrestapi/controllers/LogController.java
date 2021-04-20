package com.firstrestapi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.firstrestapi.services.LogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class LogController {
    private ObjectMapper objectMapper;
    private final LogServices logServices;

    @Autowired
    public LogController(LogServices logServices, ObjectMapper objectMapper) {
        this.logServices = logServices;
        this.objectMapper = objectMapper;
    }

    @GetMapping ("/logEntries")
    public ObjectNode getEntries() {
        ObjectNode objectNode = objectMapper.createObjectNode();
        ArrayNode arrayNode = objectMapper.valueToTree(logServices.getLogEntries());
        objectNode.putArray("entries").addAll(arrayNode);
        objectNode.put("entry_count", logServices.countLogEntries());
        return objectNode;
    }

}