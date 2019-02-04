package com.toko.maju.controllers.v1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toko.maju.domains.v1.Customer;
import com.toko.maju.response.v1.ResponseUtil;
import com.toko.maju.services.CustomerService;

class CustomerControllerTest {

	@Mock
	CustomerService customerService;
	
	@Autowired
	ResponseUtil responseUtil;

	@InjectMocks
	CustomerController customerController;

	MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	@Test
	void testListCustomers() throws Exception {
		Customer customer1 = Customer.builder().name("Customer 1").code("Code 1").address("address 1").build();
		Customer customer2 = Customer.builder().name("Customer 2").code("Code 2").address("address 2").build();

		Set<Customer> customers = new HashSet<Customer>();
		customers.add(customer1);
		customers.add(customer2);
		when(customerService.getAll()).thenReturn(customers);

		mockMvc.perform(get(CustomerController.BASE_URL)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
			//.andExpect(jsonPath("$.customers", hasSize(2)));;

	}

	@Test
	void testGetById() throws Exception {
		Customer customer1 = Customer.builder().name("Customer 1").code("Code 1").address("address 1").build();

		when(customerService.findById(1L)).thenReturn(customer1);

		mockMvc.perform(get(CustomerController.BASE_URL + "/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				//.andReturn().getResponse().getContentAsString();
				.andExpect(jsonPath("$.data.name", equalTo("Customer 1")));

	}

	@Test
	void testSaveNewCustomer() throws Exception {
		Customer customer1 = Customer.builder().name("Customer 1").code("Code 1").address("address 1").build();

		Customer returnCustomer = Customer.builder().name(customer1.getName()).code(customer1.getCode())
				.address(customer1.getAddress()).build();

		when(customerService.save(customer1)).thenReturn(returnCustomer);

		mockMvc.perform(post(CustomerController.BASE_URL + "/").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(customer1)));
	}

	@Test
	void testUpdateCustomer() throws Exception {
		Customer customer1 = Customer.builder().name("Customer 1").code("Code 1").address("address 1").build();

		Customer returnCustomer = Customer.builder().name(customer1.getName()).code(customer1.getCode())
				.address(customer1.getAddress()).build();

		when(customerService.updateById(anyLong(), any())).thenReturn(returnCustomer);

		mockMvc.perform(put(CustomerController.BASE_URL + "/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(customer1)))
			.andExpect(jsonPath("$.data.name", equalTo("Customer 1")));
	}
	
	@Test
	void deleteCustomer() throws Exception {
		
		mockMvc.perform(delete(CustomerController.BASE_URL + "/1"))
			.andExpect(status().isOk());
	}

	private static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
