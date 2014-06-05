package com.toolstar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolstar.dao.OrderDao;
import com.toolstar.domain.Order;
import com.toolstar.domain.User;


@Service
public class UserServiceImpl {

	//@Autowired
	private OrderDao orderDao;

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
