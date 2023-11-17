package com.sapient.bankingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.bankingapp.model.Account;
import com.sapient.bankingapp.model.Customer;
import com.sapient.bankingapp.repository.AccountRepository;

@Service
public class AccountService {
	// Add a Code with proper methods and annotations

	@Autowired
	private AccountRepository accountRepository;

	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	public Account findById(String id) {
		return accountRepository.findById(id).get();
	}

	public void save(Account account) {
		accountRepository.save(account);
	}

	public void update(int id, Account account) {
		accountRepository.save(account);
	}

	public Account findByAccountNumber(String accountNumber) {
		return accountRepository.findByAccountNumber(accountNumber);
	}

	public List<Account> findByCustomer(Customer customer) {
		return accountRepository.findByCustomer(customer);
	}

}
