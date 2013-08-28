package main.java.service;

import main.java.domain.User;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
   
	User getUser(User user);
	  
	User getUser(String username);
}
