package com.toko.maju.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.toko.maju.domains.v1.Customer;
import com.toko.maju.repositories.CustomerRepo;
import com.toko.maju.services.CustomerService;

//@Slf4j
class CustomerServiceImplTest {

	@Mock
	CustomerRepo customerRepo;

	@Mock
	CustomerService customerService;

	Customer testCustomer;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		testCustomer = Customer.builder().name("name 1").build();

	}

	@Test
	void testSave() {
		when(customerService.save(any())).thenReturn(testCustomer);

		Customer savedCustomer = customerService.save(any());
		assertEquals(testCustomer.getId(), savedCustomer.getId());

		verify(customerService, times(1)).save(any());

	}

	@Test
	void testUpdate() {
		when(customerService.save(any())).thenReturn(testCustomer);

		Customer savedCustomer = customerService.save(any());
		assertEquals(testCustomer.getId(), savedCustomer.getId());

		verify(customerService, times(1)).save(any());

	}

	@SuppressWarnings("static-access")
	@Test
	void getAllCustomers() {
		Set<Customer> customers = new HashSet<Customer>();
		customers.add(new Customer().builder().id(1L).address("address 1").build());
		customers.add(new Customer().builder().id(2L).address("Address 2").build());
		when(customerService.getAll()).thenReturn(customers);

		assertEquals(2, customerService.getAll().size());
		verify(customerService, times(1)).getAll();
	}

	@Test
	void findId() {
		when(customerService.findById(any())).thenReturn(testCustomer);

		Customer found = customerService.findById(anyLong());
		assertEquals(found.getId(), testCustomer.getId());
		verify(customerService, times(1)).findById(anyLong());
	}

}
