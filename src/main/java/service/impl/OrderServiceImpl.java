package main.java.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import main.java.dao.OrderDao;
import main.java.domain.Order;
import main.java.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	
	/**
	 * 处理后台数据接口
	 * */
	private OrderDao orderDao;

	public OrderDao getOrderDao() {
		return orderDao;
	}

	@Resource(name = "orderDao")  
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

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
