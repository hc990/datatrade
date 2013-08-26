package main.java.dao;

import java.util.List;

import main.java.domain.Order;
import main.java.domain.User;

public interface OrderDao {
	 long saveOrder(Order order);
	 
	 Order getOrder(Long id);
	 
	 List<Order> getOrders(User user);
	 
	 
}
