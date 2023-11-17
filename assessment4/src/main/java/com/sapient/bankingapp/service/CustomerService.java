package com.sapient.bankingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.bankingapp.model.Customer;
import com.sapient.bankingapp.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {
	// Add a Code with proper methods and annotations
	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> findAll() {
		log.info("Inside Customer Service findALL method");
		return customerRepository.findAll();
	}

	public Customer findById(String id) {
		return customerRepository.findById(id).get();
	}

	public Customer findByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	public void update(String id, Customer customer) {
		customerRepository.save(customer);
	}
}
