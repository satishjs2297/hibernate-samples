package com.accolite.au.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.au.hibernate.model.Employee;
import com.accolite.au.interfaces.EmployeeDAO;

public class EmployeeHibernateDAO implements EmployeeDAO {

	@Override
	public List<Employee> getAllEmployees() {
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		try (Session session = sessFact.getCurrentSession();) {
			session.beginTransaction();
			return session.createQuery("from Employee", Employee.class).list();
			//select * from employee //sql native
		}
	}

	@Override
	public void saveEmployee(Employee employee) {
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		try (Session session = sessFact.getCurrentSession();) {
			session.getTransaction().begin();
			session.save(employee);
			session.getTransaction().commit();
		}
	}

	/**************************/
	// CriteriaQuery<Employee> cq =
	// session.getCriteriaBuilder().createQuery(Employee.class);
	// cq.from(Employee.class);
	// return session.createQuery(cq).getResultList();

}