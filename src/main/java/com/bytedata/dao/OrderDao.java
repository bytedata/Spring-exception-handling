package com.bytedata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytedata.model.Order;

//@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {

	Order findByName(String name);

}
