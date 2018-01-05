package com.accolite.au.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.au.hibernate.model.Employee;
import com.accolite.au.interfaces.EmployeeHibernateDAO;

public class EmployeeHibernateDAOImpl implements EmployeeHibernateDAO {

	SessionFactory sessFact = HibernateUtil.getSessionFactory();

	@Override
	public List<Employee> getAllEmployees() {
		try (Session session = sessFact.getCurrentSession();) {
			session.beginTransaction();

			//HQL Query
			return session.createQuery("from Employee", Employee.class).list();
			
			//Native Sql Query: // select * from employee //sql native
			//return session.createNativeQuery("select * from employee", Employee.class).list();
			
			//CriteriaQuery api
//			 CriteriaQuery<Employee> cq =
//			 session.getCriteriaBuilder().createQuery(Employee.class);
//			 cq.from(Employee.class);
//			 return session.createQuery(cq).getResultList();
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
			// emp = session.find(Employee.class, id); //eager always make db call
			// emp = session.get(Employee.class, id); //eager, always make db call
			emp = session.load(Employee.class, id); // Load is lazy, comment
													// sysout to see the
													// difference
			System.out.println("employee :: " + emp);
		}
		return emp;
	}

	@Override
	public Employee getNamedQueryEmployeeById(int id) {
		Employee emp = null;
		try (Session session = sessFact.getCurrentSession();) {
			session.beginTransaction();
			emp = session.createNamedQuery("getEmployeeById", Employee.class)
				   .setParameter("empId", id)
				   .uniqueResult();
		}
		return emp;
	}

	@Override
	public void objectStates() {
		//Transient state
		Employee emp = new Employee("SK", "sk@gmail.com", "42343342432");
		System.out.println("Transient state:: "+emp);
		try (Session session = sessFact.openSession();) {
			session.beginTransaction();
			
			session.save(emp);
			System.out.println("Persistece state:: "+emp);
			
			session.getTransaction().commit();
			System.out.println("Is emp associated with session :: "+ session.contains(emp));
			session.evict(emp); //Detached
			System.out.println("Is emp associated with session :: "+ session.contains(emp));
			//session.clear();
			session.close();
		}
		try (Session session = sessFact.openSession();) {
			session.beginTransaction();
			emp.setEmpMobileNos("3434324253234354");
			System.out.println("merge::Is emp associated with session :: "+ session.contains(emp));
			session.merge(emp);
			System.out.println("merge::Is emp associated with session :: "+ session.contains(emp));
			session.getTransaction().commit();
		}

		
	}
}