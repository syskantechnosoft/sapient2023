package com.sapient.firstboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.firstboot.model.Employee;
import com.sapient.firstboot.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	@GetMapping("/employees/{id}")
	public Employee findById(@PathVariable int id) {
		return employeeService.findById(id);
	}
	@PostMapping("/employees")
	public void save(@RequestBody Employee employee) {
		employeeService.save(employee);
	}
	@PutMapping("/employees/{id}")
	public void update(@PathVariable int id,@RequestBody Employee updatedEmployee) {
		employeeService.update(id, updatedEmployee);
	}
	@DeleteMapping("/employees/{id}")
	public void delete(@PathVariable int id) {
		employeeService.delete(id);
	}
}
