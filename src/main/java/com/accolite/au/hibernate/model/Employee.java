package com.accolite.au.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "employee")

@NamedQueries({
	@NamedQuery(name="getEmployeeById", query="from Employee where id=:empId")		
})
public class Employee implements Serializable {

	public Employee() {

	}

	public Employee(String empName, String empAddress, String empMobileNos) {
		this.empAddress = empAddress;
		this.empName = empName;
		this.empMobileNos = empMobileNos;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "emp_address")
	private String empAddress;

	@Column(name = "emp_mobile_nos")
	private String empMobileNos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpMobileNos() {
		return empMobileNos;
	}

	public void setEmpMobileNos(String empMobileNos) {
		this.empMobileNos = empMobileNos;
	}

	@Override
	public String toString() {
		return "\n Employee ["
				+ "id=" + id 
				+ ", empName=" + empName 
				+ ", empAddress=" + empAddress 
				+ ", empMobileNos="+ empMobileNos 
				+ "]";
	}

}
