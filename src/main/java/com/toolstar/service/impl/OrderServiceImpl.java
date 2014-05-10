package com.toolstar.service.impl;

import org.springframework.stereotype.Service;

import com.toolstar.dao.OrderDao;
import com.toolstar.domain.Order;
import com.toolstar.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService{

	
	/**
	 * 
	 * */
	private OrderDao orderDao;

	@Override
	public Order saveOrder(long id) {
		// TODO Auto-generated method stub
		Order order = new Order();
		order.setAddress("dddddd");
		order.setPhonenum("cccc");
		orderDao.saveOrder(order);
		return order;
	}

}
