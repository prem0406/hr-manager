package com.nagarro.hrmanager.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.nagarro.hrmanager.model.User;
import com.nagarro.hrmanager.util.UserHibernateUtil;

public class UserRepo {
	
	public User getUser(String username, String password) {
		Transaction transaction = null;
		User userToReturn = null;
		
		
		try {
			Session session = UserHibernateUtil.getSessionFactory().openSession();
			
			//start a transaction
			transaction = session.beginTransaction();
			
			//getting User
			User user = session.get(User.class, username);
			
			if(user != null) {
				if (user.getPassword().equals(password)) {
					userToReturn = user;
				}
			}
			
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
		}
		return userToReturn;
	}
	
}
