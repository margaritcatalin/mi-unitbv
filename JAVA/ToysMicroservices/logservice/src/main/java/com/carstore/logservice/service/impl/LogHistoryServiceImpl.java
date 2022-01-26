package com.carstore.logservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carstore.logservice.dao.LogHistoryDao;
import com.carstore.logservice.model.LogHistory;
import com.carstore.logservice.service.LogHistoryService;

@Service
public class LogHistoryServiceImpl implements LogHistoryService {

	@Autowired
	LogHistoryDao logHistoryDao;

	public List<LogHistory> findAll() {
		return (List<LogHistory>) logHistoryDao.findAll();
	}

	public LogHistory findOne(Long id) {
		return logHistoryDao.findById(id).orElse(null);
	}

	public LogHistory save(LogHistory logHistory) {
		return logHistoryDao.save(logHistory);
	}

	public void removeOne(Long id) {
		logHistoryDao.deleteById(id);
	}

}
