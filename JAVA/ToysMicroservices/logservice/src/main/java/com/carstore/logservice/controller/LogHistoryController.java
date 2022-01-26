package com.carstore.logservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carstore.logservice.model.LogHistory;
import com.carstore.logservice.service.LogHistoryService;

@RestController
@RequestMapping("/logg")
public class LogHistoryController {

	@Autowired
	private LogHistoryService logHistoryService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public LogHistory addCarPost(@RequestBody LogHistory logHistory) {
		return logHistoryService.save(logHistory);
	}
	public LogHistoryService getLogHistoryService() {
		return logHistoryService;
	}
	
	public void setLogHistoryService(LogHistoryService logHistoryService) {
		this.logHistoryService = logHistoryService;
	}
}
