package com.sapient.bankingapp.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.bankingapp.model.Customer;
import com.sapient.bankingapp.repository.CustomerRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest1 {
	@Autowired
//	@Mock
	private MockMvc mockMvc;

	@Mock
	private CustomerRepository customerRepository;

	@InjectMocks
	private CustomerController customerController;

	// This object will be magically initialized by the initFields method below.
	private JacksonTester<Customer> customer;

	@BeforeAll
	public void setup() {
		// MockitoAnnotations.initMocks(this);
		// Here we can't use @AutoConfigureJsonTesters because there isn't a Spring
		// context
		JacksonTester.initFields(this, new ObjectMapper());
		// MockMvc standalone approach
		mockMvc = MockMvcBuilders.standaloneSetup(customerController)
//                .setControllerAdvice(new SuperHeroExceptionHandler())
//                .addFilters(new SuperHeroFilter())
				.build();
	}

	// Define other dependencies and variables as needed
	@Test
	@Disabled
	public void testGetCustomerById() throws Exception {
		// Define test logic for sending a GET request to /customers/{id}
		// Use mockMvc to perform the request
		// Assert the expected status code and response content

		MvcResult result = mockMvc.perform(get("api/v1/customers/{id}", "customer_id")).andExpect(status().isOk())
				.andReturn();

		MockHttpServletResponse response = result.getResponse();
		assertEquals(200, response.getStatus());
		assertThat(response.getContentAsString()).contains("John Doe");

	}

	@Test
	@Disabled
	public void testCreateCustomer() throws Exception {
		// Define test logic for sending a POST request to /customers
		// Use mockMvc to perform the request
		// Assert the expected status code and response content
	}

	// Add more test methods for other controller endpoints

//	Be sure to write test cases for error scenarios as well.
//	Test how controller handles exceptions and returns appropriate error responses.

}
