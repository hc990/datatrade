package com.toolstar.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.toolstar.dao.OrderDao;
import com.toolstar.domain.Order;
import com.toolstar.domain.User;


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
