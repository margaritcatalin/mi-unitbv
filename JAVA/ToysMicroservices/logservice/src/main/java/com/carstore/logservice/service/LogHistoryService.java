package com.carstore.logservice.service;

import java.util.List;

import com.carstore.logservice.model.LogHistory;

public interface LogHistoryService {
    List<LogHistory> findAll();

    LogHistory findOne(Long id);

    LogHistory save(LogHistory car);

    void removeOne(Long id);
}
