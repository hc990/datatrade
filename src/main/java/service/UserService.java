package service;

import org.springframework.stereotype.Service;

import domain.User;

@Service
public interface UserService {
   
	User getUser(User user);
	  
	User getUser(String username);
}
