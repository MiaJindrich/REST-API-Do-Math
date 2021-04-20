package com.firstrestapi.services;

import com.firstrestapi.models.Log;
import com.firstrestapi.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServices {
    private LogRepository logRepository;

    @Autowired
    public LogServices(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void saveLog(String endpoint, String data) {
        Log log = new Log(endpoint, data);
        logRepository.save(log);
    }

    public Long countLogEntries() {
        return logRepository.count();
    }

    public List<Log> getLogEntries() {
        return logRepository.getAllLogs();
    }

}
