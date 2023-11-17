/**
 * 
 */
package com.sapient.bankingapp.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.sapient.bankingapp.model.Customer;
import com.sapient.bankingapp.service.CustomerService;

/**
 * 
 */
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

	@MockBean
	private CustomerService customerService;

	@Autowired
	MockMvc mockMvc;
	
	private static List<Customer> customers = null;
	
	private static Customer customer = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		customer = new Customer("test", "ABCD", "abcd@gmail.com", 9878987867L, "Humming Gardens", "Chennai",
				"603103", "TamilNadu", "India");
		customers = Arrays.asList(customer);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.sapient.bankingapp.controller.CustomerController#findAll()}.
	 */
	@Test
	final void testFindAll() throws Exception {
//		fail("Not yet implemented"); // TODO
		

		Mockito.when(customerService.findAll()).thenReturn(customers);

		mockMvc.perform(get("/api/v1/customers")).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.hasSize(1))).andExpect(jsonPath("$[0].name", Matchers.is("ABCD")));

	}

	/**
	 * Test method for
	 * {@link com.sapient.bankingapp.controller.CustomerController#findById(java.lang.String)}.
	 */
	@Test
	final void testFindById() {
//		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link com.sapient.bankingapp.controller.CustomerController#findByEmail(java.lang.String)}.
	 */
	@Test
	final void testFindByEmail() {
//		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link com.sapient.bankingapp.controller.CustomerController#save(com.sapient.bankingapp.model.Customer)}.
	 */
	@Test
	final void testSave() {
//		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link com.sapient.bankingapp.controller.CustomerController#update(java.lang.String, com.sapient.bankingapp.model.Customer)}.
	 */
	@Test
	final void testUpdate() {
//		fail("Not yet implemented"); // TODO
	}

}
