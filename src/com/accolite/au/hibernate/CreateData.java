package com.accolite.au.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.au.hibernate.model.*;

public class CreateData {
	public static void main(String[] args) throws Exception {

		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();
		Employee emp = new Employee();
		emp.setEmpName("Satish");
		emp.setEmpMobileNos("000000");
		emp.setEmpAddress("Hyderabad - India");
		session.save(emp);
		tr.commit();
		System.out.println("Successfully inserted");
		sessFact.close();
	}

}