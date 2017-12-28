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
		for(int i = 0; i < 10; i++) {
			Employee emp = new Employee("Hyd"+i,"testing"+i,"abc123"+i);
			empDao.saveEmployee(emp);
		}
	}
	
	@Test
	@Ignore
	public void testgetEmployeeId() {
		Employee employee = empDao.getEmployeeById(1);
	}
	
	@Test
	public void testRemoveEmployee() {
		Employee employee = empDao.getEmployeeById(2);
		empDao.deleteEmployee(employee);
	}
}
