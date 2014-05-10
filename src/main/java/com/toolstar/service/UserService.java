package com.toolstar.service;

import org.springframework.stereotype.Service;

import com.toolstar.domain.User;


@Service
public interface UserService {
   
	User getUser(User user);
	  
	User getUser(String username);
}
