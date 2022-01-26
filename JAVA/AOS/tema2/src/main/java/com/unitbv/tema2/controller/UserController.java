package com.unitbv.tema2.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unitbv.tema2.model.User;
import com.unitbv.tema2.service.UserService;

@RestController
@RequestMapping(value="/users")

public class UserController {

	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll(){
		return service.findAll();
	}
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET, value="users", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findOne(@PathVariable("id") String userId){
		return service.findOne(userId);
	}
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User create(@RequestBody User user){
		return service.create(user);
	}
	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT, value="{id}", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User update(@PathVariable("id") String id, @RequestBody User user){
		return service.update(id, user);
	}
	@ResponseBody
	@RequestMapping(method=RequestMethod.DELETE, value="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void delete(@PathVariable("id") String id){
		service.delete(id);
	}
}
