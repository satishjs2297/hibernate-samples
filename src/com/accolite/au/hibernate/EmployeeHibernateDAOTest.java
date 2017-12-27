package com.accolite.au.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.accolite.au.hibernate.model.Employee;
import com.accolite.au.interfaces.EmployeeDAO;

public class EmployeeHibernateDAOTest {
	
	EmployeeDAO empDao = null;
	
	@Before
	public void setUp() {
		empDao = new EmployeeHibernateDAO();
	}
	
	@Test
	@Ignore
	public void testGetAllEmployees() throws SQLException {
		List<Employee> list = empDao.getAllEmployees();
		System.out.println(list);
	}

	@Test
	public void testSaveEmployee() {
		Employee emp = new Employee("Hyd","testing","abc123");
		empDao.saveEmployee(emp);
	}
}
