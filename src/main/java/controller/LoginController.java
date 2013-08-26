package main.java.controller;

import main.java.domain.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginController extends ActionSupport implements ModelDriven<User> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2843710489038468506L;
	
	User user = new User();
	
	@Override
	public String execute() throws Exception {	
		// TODO Auto-generated method stub
		String username = user.getUsername();
		String password = user.getPassword();
		
	
		
		return SUCCESS;
	}
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
