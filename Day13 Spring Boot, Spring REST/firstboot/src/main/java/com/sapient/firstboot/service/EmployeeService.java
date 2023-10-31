package com.sapient.firstboot.service;

import java.util.List;

import com.sapient.firstboot.model.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void update(int id, Employee updatedEmployee);
	
	public void delete(int id);

}
