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

import com.sapient.bankingapp.model.Account;
import com.sapient.bankingapp.model.Customer;
import com.sapient.bankingapp.service.AccountService;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/accounts")
	public List<Account> findAll() {
		return accountService.findAll();
	}
	@GetMapping("/accounts/{id}")
	public Account findById(@PathVariable String id) {
		return accountService.findById(id);
	}
	
	@PostMapping("/accounts")
	public void save(@RequestBody Account account) {
		accountService.save(account);
	}
	
	@PutMapping("/accounts/{id}")
	public void update(@PathVariable String id,@RequestBody Account account) {
		accountService.save(account);
	}
	
	@GetMapping("/customers/{id}/accounts")
	public List<Account> findByCustomer(Customer customer){
		return accountService.findByCustomer(customer);
	}
	

}
