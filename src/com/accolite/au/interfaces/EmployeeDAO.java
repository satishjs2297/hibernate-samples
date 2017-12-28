package com.accolite.au.interfaces;

import java.util.List;

import com.accolite.au.hibernate.model.Employee;

public interface EmployeeDAO {
	
	//CRUD
	public Employee getEmployeeById(int id);
	public List<Employee> getAllEmployees();
	public void saveEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public default void removeEmployee(Employee employee) {
		System.out.println("dummy remove method");
	}
	public void deleteEmployee(Employee employee);
	
	
}
