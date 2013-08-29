package service.impl;

import org.springframework.stereotype.Service;

import service.OrderService;
import dao.OrderDao;
import domain.Order;

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
