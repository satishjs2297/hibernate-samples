package com.accolite.au.hibernate;

import org.junit.Before;
import org.junit.Test;

import com.accolite.au.hibernate.model.User;

public class UserDaoTest {
	
	UserDao userDao = null;
	
	@Before
	public void setUp() {
		userDao = new UserDao();
	}
	
	@Test
	public void testSaveUser() {
		User user = new User("veerraju", "9866744203", "Hyderabad", "Manikonda", "AP");
		userDao.saveUser(user);
	}
	
	@Test
	public void testGetUser() {
		User user = userDao.getUser("veerraju", "9866744203");
		System.out.println("user >>>>>>>>>. "+user);
	}


}
