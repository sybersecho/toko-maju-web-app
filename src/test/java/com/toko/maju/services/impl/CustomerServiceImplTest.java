package com.toko.maju.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
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
import com.toko.maju.domains.Customer;
import com.toko.maju.repositories.CustomerRepo;
import com.toko.maju.services.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
//		customerService = new CustomerServiceImpl(customerRepo, customerMapper);
		testCustomer = CustomerDTO.builder().id(1L).build();

	}

	@Test
	void testSave() {
//		CustomerDTO toSaved = CustomerDTO.builder().id(1L).build();
		when(customerService.save(any())).thenReturn(testCustomer);

		CustomerDTO savedCustomer = customerService.save(any());
		assertEquals(testCustomer.getId(), savedCustomer.getId());

		verify(customerService, times(1)).save(any());

	}

	@Test
	void findAll() {
		List<Customer> customers = Arrays.asList(new Customer(), new Customer());
		when(customerRepo.findAll()).thenReturn(customers);
		log.debug("has error");
		assertEquals(2, customerRepo.findAll().size());

	}

}
