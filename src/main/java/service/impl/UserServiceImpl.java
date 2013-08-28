package main.java.service.impl;

import javax.annotation.Resource;

import main.java.dao.OrderDao;
import main.java.domain.Order;
import main.java.domain.User;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

	private OrderDao orderDao;

	public OrderDao getOrderDao() {
		return orderDao;
	}

	@Resource(name = "orderDao")  
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public User getUser() {
		User user = new User();
		user.setPassword("12213");
		user.setUsername("dfasdfsd");
		
		Order order = new Order();
		order.setAddress("aaaaa");
		order.setPhonenum("bbbbbb");
		orderDao.saveOrder(order);
		return user;
	}
}
