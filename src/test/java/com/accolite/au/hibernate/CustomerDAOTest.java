package com.accolite.au.hibernate;

import org.junit.Before;
import org.junit.Test;

import com.accolite.au.hibernate.model.Account;
import com.accolite.au.hibernate.model.Customer;

public class CustomerDAOTest {

	private CustomerDAO customerDAO;
	
	@Before
	public void setUp() {
		customerDAO = new CustomerDAO();
	}

	@Test
	public void testPersistCustomer() {
		Customer customer = new Customer("Veerraju", "Business");
		customerDAO.persistCustomer(customer);
		Account account = new Account("Veerraju", "Savings");
		account.setCustomer(customer);
		customer.getAccounts().add(account);
		customerDAO.persistAccount(account);
	}
	
	@Test
	public void testGetCustomer() {
		Customer customer = customerDAO.getCustomerByCustId(1l);
	}

}
