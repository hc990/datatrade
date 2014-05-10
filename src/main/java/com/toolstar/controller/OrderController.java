package com.toolstar.controller;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.toolstar.domain.User;


@Controller
public class OrderController extends ActionSupport implements ModelDriven<User> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -569060708014398859L;

	@Override
	public String execute() throws Exception {	
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public void validate() {
		addFieldError("name", getText("wrong"));
	}

	@Override
	public User getModel() {
		User u = new User();
		// TODO Auto-generated method stub
		return u;
	}

}
