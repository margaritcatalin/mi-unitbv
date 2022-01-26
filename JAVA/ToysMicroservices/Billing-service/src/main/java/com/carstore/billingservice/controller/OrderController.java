package com.carstore.billingservice.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carstore.CarStoreModel.dao.UserRepository;
import com.carstore.CarStoreModel.model.Order;
import com.carstore.CarStoreModel.model.User;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/getOrderList")
	public List<Order> getOrderList(Principal principal) {
		User user = userRepository.findByUsername(principal.getName());
		List<Order> orderList = user.getOrderList();
		return orderList;
	}

}

