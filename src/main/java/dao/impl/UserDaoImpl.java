package main.java.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import main.java.dao.UserDao;
import main.java.domain.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.findByExample(user);
		return null;
	}

}
