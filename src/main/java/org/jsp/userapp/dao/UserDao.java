package org.jsp.userapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.jsp.userapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	EntityManager manager;
	
	
	public User saveUser(User user) {
		EntityTransaction transaction = manager.getTransaction();
		 manager.persist(user);
		 transaction.begin();
		 transaction.commit();
		return user;
	}
	
	public User updateUser(User user) {
		EntityTransaction entityTransaction = manager.getTransaction();
		entityTransaction.begin();
		manager.merge(user);
		entityTransaction.commit();
		return user;
	}
	
	
	
	
	public User userVerification(String name ,String password) {
		Query q = manager.createQuery("Select U From User U Where U.name=?1 and U.password=?2");
		q.setParameter(1, name);
		q.setParameter(2, password);
		List<User>users = q.getResultList();
		if(users.size()>0) {
			return users.get(0);
		}
		return null;
			
	}
	
	public   List<User> ShowAllUser(){
		Query q = manager.createQuery("Select U From User U ");
		return q.getResultList();

	}
	public boolean DeleteUser(int id) {
		EntityTransaction transaction = manager.getTransaction();
		User u = manager.find(User.class, id);
		if(u!=null) {
			manager.remove(u);
			transaction.begin();
			transaction.commit();
			return true;
		}
		return false;
	}
	
	public User findUserById(int id) {
		return manager.find(User.class, id);
	}
	

}
