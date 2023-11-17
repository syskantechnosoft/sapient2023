package com.sapient.bankingapp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sapient.bankingapp.model.Customer;
import com.sapient.bankingapp.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

	@InjectMocks
	CustomerService customerService;

	@Mock
	CustomerRepository customerRepository;

	private static List<Customer> customers = null;

	private static Customer customer = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		customer = new Customer("test", "ABCD", "abcd@gmail.com", 9878987867L, "Humming Gardens", "Chennai", "603103",
				"TamilNadu", "India");
		customers = Arrays.asList(customer);
	}

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	final void testFindAll() {
//		fail("Not yet implemented"); // TODO
		when(customerRepository.findAll()).thenReturn(customers);

	    //test
	    List<Customer> customersList = customerService.findAll();

	    assertEquals(1, customersList.size());
	    verify(customerRepository, times(1)).findAll();
	}

	@Test
	final void testFindById() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testFindByEmail() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSave() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testUpdate() {
		fail("Not yet implemented"); // TODO
	}

}
