package org.jsp.userapp.service;

import java.util.List;

import javax.persistence.EntityTransaction;

import org.jsp.userapp.dao.UserDao;
import org.jsp.userapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	public User saveUser(User user) {
		return dao.saveUser(user);
	}
	
	public User updateUser(User user) {
		
		return dao.updateUser(user);
	}
	public  User userVerification(String name ,String password) {
			
			return dao.userVerification(name, password);
	}
	
	public boolean DeleteUser(int id) {
		
		return dao.DeleteUser(id);
}
	
	public  User findUserById(int id) {
		return dao.findUserById(id);
	}
	
public List<User> ShowAllUser() {
		
		return dao.ShowAllUser();
	}
	
}
