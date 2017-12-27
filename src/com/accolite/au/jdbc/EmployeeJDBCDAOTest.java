package com.accolite.au.jdbc;

import java.sql.SQLException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.accolite.au.hibernate.model.Employee;

public class EmployeeJDBCDAOTest {
	
	@Test
	@Ignore
	public void testGetAllEmployees() throws SQLException {
		EmployeeJDBCDAO empDao = new EmployeeJDBCDAO();
		List<Employee> list = empDao.getAllEmployees();
		System.out.println(list);
	}
	
	@Test
	public void testSaveEmployee() {
		EmployeeJDBCDAO empDao = new EmployeeJDBCDAO();
		Employee emp = new Employee();
		emp.setEmpAddress("Hyderbad");
		emp.setEmpMobileNos("323324");
		emp.setEmpName("Testing Employee!!");
		empDao.saveEmployee(emp);
	}
	
}
