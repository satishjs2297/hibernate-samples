package com.accolite.au.hibernate;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.au.hibernate.model.Account;
import com.accolite.au.hibernate.model.Customer;

public class CustomerDAO {

	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public void persistCustomer(Customer customer) {
		try(Session session = sessionFactory.getCurrentSession()) {
			session.beginTransaction();
			session.save(customer);
			session.getTransaction().commit();
		}
	}
	
	public void persistAccount(Account account){
		try(Session session = sessionFactory.getCurrentSession()) {
			session.beginTransaction();
			session.save(account);
			session.getTransaction().commit();
		}		
	}
	
	public Customer getCustomerByCustId(Long custId) {		
		Customer customer = null;
		try(Session session = sessionFactory.getCurrentSession()) {
			session.beginTransaction();
			customer = session.find(Customer.class, custId);
			System.out.println("customer :: "+customer);
			Set<Account> accounts = customer.getAccounts();
			System.out.println("customer :: "+accounts);
			session.getTransaction().commit();
		}
		return customer;
	}
	
}
