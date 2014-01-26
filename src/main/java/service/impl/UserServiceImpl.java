package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.UserService;
import dao.OrderDao;
import domain.Order;
import domain.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
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

	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
