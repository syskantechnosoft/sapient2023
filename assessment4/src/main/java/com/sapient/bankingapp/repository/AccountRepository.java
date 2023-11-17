package com.sapient.bankingapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sapient.bankingapp.model.Account;
import com.sapient.bankingapp.model.Customer;

public interface AccountRepository extends MongoRepository<Account, String> {
	// Add Necessary code to make it as a MongoRepo

	Account findByAccountNumber(String accountNumber);

	List<Account> findByCustomer(Customer customer);
}
