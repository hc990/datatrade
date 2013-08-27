package main.java.service.impl;

import main.java.dao.OrderDao;
import main.java.domain.Order;
import main.java.service.OrderService;

import org.springframework.stereotype.Service;

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
