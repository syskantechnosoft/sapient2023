package com.sapient.bankingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.bankingapp.model.Customer;
import com.sapient.bankingapp.service.CustomerService;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> findAll() {
		return customerService.findAll();
	}

	@GetMapping("/customers/{id}")
	public Customer findById(@PathVariable String id) {
		return customerService.findById(id);
	}

	@GetMapping("/customers/email/{email}")
	public Customer findByEmail(@PathVariable String email) {
		return customerService.findByEmail(email);
	}

	@PostMapping("/customers")
	public void save(@RequestBody Customer customer) {
		customerService.save(customer);
	}

	@PutMapping("/customers/{id}")
	public void update(@PathVariable String id, @RequestBody Customer customer) {
		customerService.update(id, customer);
	}
}
