 package com.bytedata.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytedata.dao.OrderDao;
import com.bytedata.exception.OrderException;
import com.bytedata.model.Order;

@Service
public class OrderService {
	@Autowired
	public OrderDao orderDao;

	@PostConstruct
	public void addOrder() {
		List<Order> orderList = new ArrayList<>();
		orderList.add(new Order(777, "chetak", "Automobil", 50000));
		orderList.add(new Order(444, "tata", "Commer-vehicle", 400000));
		orderList.add(new Order(111, "hero", "bycycle", 3000));
		orderDao.saveAll(orderList);

	}

	public double getPrice(String name) throws OrderException {
		Order order = null;
		double amount = 0;
		try {
			order = orderDao.findByName(name);
			amount = order.getAmount();
		} catch (Exception e) {
			throw new OrderException("Order "+name+" is not found ");
		}
		return amount; 
	}
}
