package com.accolite.au.interfaces;

import com.accolite.au.hibernate.model.Employee;

public interface EmployeeHibernateDAO extends EmployeeDAO {
	
	public Employee getNamedQueryEmployeeById(int id);
	public void objectStates();

}
