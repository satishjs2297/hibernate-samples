package com.accolite.au.interfaces;

import java.util.List;

import com.accolite.au.hibernate.model.Employee;

public interface EmployeeDAO {
	public List<Employee> getAllEmployees();

	public void saveEmployee(Employee employee);
}
