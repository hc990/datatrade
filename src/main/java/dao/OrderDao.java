package dao;

import java.util.List;

import domain.Order;
import domain.User;

public interface OrderDao {
	 long saveOrder(Order order);
	 
	 Order getOrder(Long id);
	 
	 List<Order> getOrders(User user);
	 
	 
}
