package com.toolstar.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.toolstar.dao.OrderDao;
import com.toolstar.domain.Order;
import com.toolstar.domain.User;


@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {
	

	@Autowired
	private HibernateTemplate hibernateTemplate;	

	@Override
	public List<Order> getOrders(User user) {
		// TODO Auto-generated method stub
		return hibernateTemplate.findByExample(user);  
	}
	
	@Override
	public Order getOrder(Long orderid) {
		// TODO Auto-generated method stub
		return (Order) hibernateTemplate.findByNamedQuery("orderid", orderid);
	}

	@Override
	public long saveOrder(Order order){
		// TODO Auto-generated method stub
		hibernateTemplate.saveOrUpdate(order);
		return order.getOrderid();
	}
	
}
