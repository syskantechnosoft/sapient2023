package com.sapient.firstboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.firstboot.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//	public List<Employee> findAll();
//
//	public Employee findById(int id);
//
//	public void save()
//
//	public void update(int id, Employee updatedEmployee);
//
//	public void deleteById(int id);
}
