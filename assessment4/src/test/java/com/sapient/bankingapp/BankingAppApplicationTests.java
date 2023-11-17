package com.sapient.bankingapp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sapient.bankingapp.controller.AccountController;
import com.sapient.bankingapp.controller.CustomerController;

@SpringBootTest
class BankingAppApplicationTests {

	@Autowired
	CustomerController customerController;

	@Autowired
	AccountController accountController;

	@Test
	public void contextLoads() {
		Assertions.assertThat(customerController).isNot(null);
		Assertions.assertThat(accountController).isNot(null);
	}

}
