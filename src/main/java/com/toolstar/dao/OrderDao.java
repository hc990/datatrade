package com.toolstar.dao;

import java.util.List;

import com.toolstar.domain.Order;
import com.toolstar.domain.User;


public interface OrderDao {
	 long saveOrder(Order order);
	 
	 Order getOrder(Long id);
	 
	 List<Order> getOrders(User user);
	 
	 
}
