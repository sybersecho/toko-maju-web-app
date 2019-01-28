package com.toko.maju.controllers.v1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toko.maju.api.v1.model.CustomerDTO;
import com.toko.maju.services.CustomerService;

class CustomerControllerTest {

	@Mock
	CustomerService customerService;

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
		CustomerDTO customer1 = CustomerDTO.builder().id(1L).name("Customer 1").code("Code 1").address("address 1")
				.build();
		CustomerDTO customer2 = CustomerDTO.builder().id(2L).name("Customer 2").code("Code 2").address("address 2")
				.build();

		List<CustomerDTO> customers = Arrays.asList(customer1, customer2);
		when(customerService.getAllCustomers()).thenReturn(customers);

		mockMvc.perform(get(CustomerController.BASE_URL).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.customers", hasSize(2)));

	}

	@Test
	void testGetById() throws Exception {
		CustomerDTO customer1 = CustomerDTO.builder().id(1L).name("Customer 1").code("Code 1").address("address 1")
				.build();

		when(customerService.findById(1L)).thenReturn(customer1);

		mockMvc.perform(get(CustomerController.BASE_URL + "/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.name", equalTo("Customer 1")));

	}

	@Test
	void testSaveNewCustomer() throws Exception {
		CustomerDTO customer1 = CustomerDTO.builder().id(1L).name("Customer 1").code("Code 1").address("address 1")
				.build();

		CustomerDTO returnCustomer = CustomerDTO.builder().id(customer1.getId()).name(customer1.getName())
				.code(customer1.getCode()).address(customer1.getAddress()).build();

		when(customerService.save(customer1)).thenReturn(returnCustomer);

		mockMvc.perform(post(CustomerController.BASE_URL + "/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(customer1)))
				.andExpect(jsonPath("$.name", equalTo("Customer 1")));
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
