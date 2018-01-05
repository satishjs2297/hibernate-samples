package com.accolite.au.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.accolite.au.hibernate.model.Employee;
import com.accolite.au.interfaces.EmployeeHibernateDAO;

public class EmployeeHibernateDAOTest {
	
	EmployeeHibernateDAO empDao = null;
	
	@Before
	public void setUp() {
		empDao = new EmployeeHibernateDAOImpl();
	}
	
	@Test
	public void testGetAllEmployees() throws SQLException {
		List<Employee> list = empDao.getAllEmployees();
		System.out.println(list);
	}

	@Test
	public void testSaveEmployee() {
		for(int i = 0; i < 10; i++) {
			Employee emp = new Employee("Hyd"+i,"testing"+i,"abc123"+i);
			empDao.saveEmployee(emp);
		}
	}
	
	@Test
	public void testgetEmployeeId() {
		Employee employee = empDao.getEmployeeById(1);
		System.out.println("employee :: "+employee);
	}
	
	@Test
	public void testRemoveEmployee() {
		Employee employee = empDao.getEmployeeById(3);
		empDao.deleteEmployee(employee);
	}
	
	@Test
	public void testGetNamedQueryEmployeeById() {
		Employee emp = empDao.getNamedQueryEmployeeById(4);
		System.out.println("emp :::"+emp);
	}
	
	@Test
	public void testObjectStates() {
		empDao.objectStates();
	}
}
