package com.accolite.au.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.accolite.au.hibernate.model.Employee;
import com.accolite.au.interfaces.EmployeeDAO;

public class EmployeeJDBCDAO implements EmployeeDAO {

	public List<Employee> getAllEmployees() {
		List<Employee> lst = Collections.emptyList();
		try {
			final String ALL_EMP_QRY = "SELECT id, emp_address, emp_mobile_nos, emp_name FROM employee";
			try (Connection con = JDBCConnectionUtil.openConnection();) {
				try (PreparedStatement stmt = con.prepareStatement(ALL_EMP_QRY);) {
					try (ResultSet rs = stmt.executeQuery();) {
						lst = new ArrayList<>();
						while (rs.next()) {
							Employee emp = new Employee();
							emp.setId(rs.getInt("id"));
							emp.setEmpAddress(rs.getString("emp_address"));
							emp.setEmpMobileNos(rs.getString("emp_mobile_nos"));
							emp.setEmpName(rs.getString("emp_name"));
							lst.add(emp);
						}
					}
				}
			} catch (SQLException e) {
				System.err.println(e);
			} finally {
				JDBCConnectionUtil.closeConnection();
			}
		} catch (Exception ex) {
			System.err.println(ex);
		}
		return lst;
	}

	@Override
	public void saveEmployee(Employee employee) {
		try (Connection con = JDBCConnectionUtil.openConnection();) {
			//con.setAutoCommit(false);
			final String INSERT_EMP = 
			"INSERT INTO EMPLOYEE(ID, EMP_ADDRESS, EMP_MOBILE_NOS, EMP_NAME) "
			+ "VALUES(?,?,?,?)";
			final String curr_id  = "select max(id) from EMPLOYEE";
			ResultSet rs = con.prepareStatement(curr_id ).executeQuery();
			int empId = rs.next() ? rs.getInt(1) : 0;
			PreparedStatement stmt = con.prepareStatement(INSERT_EMP);
			stmt.setInt(1, ++empId);
			stmt.setString(2, employee.getEmpAddress());
			stmt.setString(3, employee.getEmpMobileNos());
			stmt.setString(4, employee.getEmpName());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
