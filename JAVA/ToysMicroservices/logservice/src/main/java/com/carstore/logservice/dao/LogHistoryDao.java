package com.carstore.logservice.dao;

import org.springframework.data.repository.CrudRepository;

import com.carstore.logservice.model.LogHistory;

public interface LogHistoryDao extends CrudRepository<LogHistory, Long> {

}
