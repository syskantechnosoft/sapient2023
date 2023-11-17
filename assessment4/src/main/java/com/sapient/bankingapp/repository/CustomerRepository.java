package com.sapient.bankingapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sapient.bankingapp.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	// Add Necessary code to make it a MongoRepo

	List<Customer> findByName(String name);

	Customer findByEmail(String email);
}
