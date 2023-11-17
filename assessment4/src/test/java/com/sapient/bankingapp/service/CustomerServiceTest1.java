package com.sapient.bankingapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.sapient.bankingapp.model.Customer;
import com.sapient.bankingapp.repository.CustomerRepository;

@SpringBootTest
public class CustomerServiceTest1 {

	@Mock
	private CustomerRepository customerRepository;

	@InjectMocks
	private CustomerService customerService;

	@BeforeAll
	public void setUp() {
		// Initialize mock data or behavior
	}

	@Test
	@Disabled
	public void testCreateCustomer() {
		// Define test logic for creating a customer
		// Use Mockito to set up mock behavior
		// Assert the expected results
	}

	@Test
	@Disabled
	public void testGetCustomerById() {
		// Define test logic for retrieving a customer
		// Use Mockito to set up mock behavior
		// Assert the expected results
//		when(customerRepository.findById("customer_id")).thenReturn(Optional.of(customerEntity));
//		Customer customer = customerService.getCustomerById("customer_id");
//		assertNotNull(customer);
//		assertEquals("John Doe", customer.getName());

	}

	// Add more test methods for other service operations
	
	
	@AfterAll
	public void tearDown() {
	    // Perform cleanup actions
	}


}
