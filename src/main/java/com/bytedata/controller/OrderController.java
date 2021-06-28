package com.bytedata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bytedata.exception.OrderException;
import com.bytedata.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	public OrderService orderService;

	@GetMapping("/getprice/{orderName}")
	public String getOrderPrice(@PathVariable String orderName) throws OrderException {
		double amount = orderService.getPrice(orderName);
		return "Total order price for " + orderName + " is RS: " + amount;
	}
}
