package com.accolite.au.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.au.hibernate.model.User;
import com.accolite.au.hibernate.model.UserPk;

public class UserDao {
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public void saveUser(User user) {
		try(Session session = sessionFactory.getCurrentSession()) {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		}
	}
	
	public User getUser(String userName, String mobileNumber) {
		try(Session session = sessionFactory.getCurrentSession()) {
			session.beginTransaction();
			return session.find(User.class, new UserPk(userName, mobileNumber));
		}
		
	}

}
