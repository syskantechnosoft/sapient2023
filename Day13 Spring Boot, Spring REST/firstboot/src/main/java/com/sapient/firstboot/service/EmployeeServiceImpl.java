package com.sapient.firstboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.firstboot.model.Employee;
import com.sapient.firstboot.repo.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}

	@Override
	public void update(int id, Employee updatedEmployee) {
		// TODO Auto-generated method stub
		employeeRepository.save(updatedEmployee);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

}
