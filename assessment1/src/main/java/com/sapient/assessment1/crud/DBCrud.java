package com.sapient.assessment1.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.sapient.assessment1.model.Employee;
import com.sapient.assessment1.util.DBUtil;

public class DBCrud {

	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	private final String INSERTQUERY = "insert into employee (name,gender,dob,email,mobile) values (?,?,?,?,?)";
	private final String SELECTQUERY = "select * from employee";
	private final String DELETEQUERY = "delete from employee where id = ?";
	private final String UPDATEQUERY = "update employee set name=?, gender=?, dob=?, email=?, mobile=? where id=?";

	public int save(Employee employee) {
		int status = 0;
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(INSERTQUERY);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getGender());
			preparedStatement.setDate(3, employee.getDob());
			preparedStatement.setString(4, employee.getEmail());
			preparedStatement.setLong(5, employee.getMobile());
			status = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return status;
	}

	public int update(int id, Employee employee) {
		int status = 0;
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(UPDATEQUERY);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getGender());
			preparedStatement.setDate(3, employee.getDob());
			preparedStatement.setString(4, employee.getEmail());
			preparedStatement.setLong(5, employee.getMobile());
			preparedStatement.setInt(6, id);
			status = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return status;
	}

	public int delete(int id) {
		int status = 0;
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(DELETEQUERY);
			preparedStatement.setInt(1, id);
			status = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return status;
	}

	public List<Employee> getAll() {
		List<Employee> employeesList = new ArrayList<Employee>();
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(SELECTQUERY);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt(1));
				employee.setName(resultSet.getString("name"));
				employee.setEmail(resultSet.getString("email"));
				employee.setGender(resultSet.getString("gender"));
				employee.setDob(resultSet.getDate("dob"));
				employee.setMobile(resultSet.getLong("mobile"));
				employeesList.add(employee);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return employeesList;
	}
	
	public List<Employee> getUniqueRecord() {
		List<Employee> employees = getAll();
		List<Employee> uniqueEmployees = new ArrayList<Employee>();	
		for (Employee employee : employees) {
			if(!uniqueEmployees.contains(employee)) {
				uniqueEmployees.add(employee);
			}
		}
		return uniqueEmployees;
	}

//	public Employee getById(int id) {
//		Employee employee = null;
//		try {
//			connection = DBUtil.getConnection();
//			preparedStatement = connection.prepareStatement(DELETEQUERY);
//			preparedStatement.setInt(1, id);
//			preparedStatement.executeUpdate();
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		}
//		return employee;
//	}
}
