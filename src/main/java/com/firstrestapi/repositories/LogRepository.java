package com.firstrestapi.repositories;

import com.firstrestapi.models.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

    @Query(value = "SELECT * FROM log.log;", nativeQuery = true)
    public List<Log> getAllLogs();

}