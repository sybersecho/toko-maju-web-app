package com.toko.maju.repositories;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.toko.maju.domains.Customer;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CustomerRepoIT {

	private final CustomerRepo customerRepo;
	private Customer customer;

	@Autowired
	public CustomerRepoIT(CustomerRepo customerRepo) {
		this.customerRepo = customerRepo;
	}

	@BeforeEach
	void setUp() throws Exception {
		customer = new Customer();
		customer.setAddress("address");
		customer.setCode("code");
		customer.setName("name");
		customer.setPhoneNumber("phone Number");
	}

	@Test
	void testSaveCustomer() {
		Customer saved =  customerRepo.save(customer);
//		Customer returned = customerRepo.findAll().get(0);
		assertNotNull(saved);
//		assertEquals(2, customerRepo.findAll().size());
		
//		assertEquals(saved.getName(), "name");
//		assertEquals(saved.getId(), returned.getId());
	}

}
