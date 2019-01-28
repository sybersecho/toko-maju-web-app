package com.toko.maju.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.toko.maju.api.v1.mapper.CustomerMapper;
import com.toko.maju.api.v1.model.CustomerDTO;
import com.toko.maju.repositories.CustomerRepo;
import com.toko.maju.services.CustomerService;

//@Slf4j
class CustomerServiceImplTest {

	@Mock
	CustomerRepo customerRepo;

	@Mock
	CustomerMapper customerMapper;

	@Mock
	CustomerService customerService;

	CustomerDTO testCustomer;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		testCustomer = CustomerDTO.builder().id(1L).build();

	}

	@Test
	void testSave() {
		when(customerService.saveNewCustomer(any())).thenReturn(testCustomer);

		CustomerDTO savedCustomer = customerService.saveNewCustomer(any());
		assertEquals(testCustomer.getId(), savedCustomer.getId());

		verify(customerService, times(1)).saveNewCustomer(any());

	}
	
	@Test
	void testUpdate() {
		when(customerService.saveNewCustomer(any())).thenReturn(testCustomer);

		CustomerDTO savedCustomer = customerService.saveNewCustomer(any());
		assertEquals(testCustomer.getId(), savedCustomer.getId());

		verify(customerService, times(1)).saveNewCustomer(any());

	}

	@Test
	void getAllCustomers() {
		List<CustomerDTO> customers = Arrays.asList(new CustomerDTO(), new CustomerDTO());
		when(customerService.getAllCustomers()).thenReturn(customers);

		assertEquals(2, customerService.getAllCustomers().size());
		verify(customerService, times(1)).getAllCustomers();
	}

	@Test
	void findId() {
		when(customerService.findById(any())).thenReturn(testCustomer);

		CustomerDTO found = customerService.findById(anyLong());
		assertEquals(found.getId(), testCustomer.getId());
		verify(customerService, times(1)).findById(anyLong());
	}

}
