package com.accolite.au.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.au.hibernate.model.Employee;
import com.accolite.au.interfaces.EmployeeDAO;

public class EmployeeHibernateDAO implements EmployeeDAO {

	SessionFactory sessFact = HibernateUtil.getSessionFactory();

	@Override
	public List<Employee> getAllEmployees() {
		try (Session session = sessFact.getCurrentSession();) {
			session.beginTransaction();
			return session.createQuery("from Employee", Employee.class).list();
			// select * from employee //sql native
		}
	}

	@Override
	public void saveEmployee(Employee employee) {
		try (Session session = sessFact.getCurrentSession();) {
			session.getTransaction().begin();
			session.save(employee);
			// session.saveUpdate(employee);
			// session.merge(employee);
			// session.persist(employee);
			session.getTransaction().commit();
		}

	}

	@Override
	public void deleteEmployee(Employee employee) {
		try (Session session = sessFact.getCurrentSession();) {
			session.getTransaction().begin();
			session.delete(employee);
			session.getTransaction().commit();
		}
	}

	@Override
	public void removeEmployee(Employee employee) {
		try (Session session = sessFact.getCurrentSession();) {
			session.getTransaction().begin();
			session.remove(employee); // JPA
			session.getTransaction().commit();
		}
	}

	@Override
	public void updateEmployee(Employee employee) {
		try (Session session = sessFact.getCurrentSession();) {
			session.getTransaction().begin();
			session.update(employee);
			// session.saveOrUpdate(employee);
			// session.merge(employee);
			session.getTransaction().commit();
		}

	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee emp = null;
		try (Session session = sessFact.getCurrentSession();) {
			session.beginTransaction();
			// emp = session.find(Employee.class, id); //eager always make db
			// call
			// emp = session.get(Employee.class, id); //eager, always make db
			// call
			emp = session.load(Employee.class, id); // Load is lazy, comment
													// sysout to see the
													// difference
			emp = session.load(Employee.class, id);
			// emp = session.get(Employee.class, id);
			// emp = session.get(Employee.class, id);
			System.out.println("employee :: " + emp);
		}
		return emp;
	}

	/**************************/
	// CriteriaQuery<Employee> cq =
	// session.getCriteriaBuilder().createQuery(Employee.class);
	// cq.from(Employee.class);
	// return session.createQuery(cq).getResultList();

}