package com.toko.maju.domains;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.toko.maju.api.v1.model.CustomerDTO;
import com.toko.maju.services.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BootStrap implements CommandLineRunner {

	private final CustomerService customerService;

	public BootStrap(CustomerService customerService) {
		this.customerService = customerService;
	}

	@Override
	public void run(String... args) throws Exception {
		loadCustomer();

	}

	private void loadCustomer() {
		CustomerDTO customer1 = CustomerDTO.builder().name("Customer 1").code("Code 1").address("address 1")
				.build();
		CustomerDTO customer2 = CustomerDTO.builder().name("Customer 2").code("Code 2").address("address 2")
				.build();
		
		customerService.saveNewCustomer(customer1);
		customerService.saveNewCustomer(customer2);
		
		log.debug("customer loaded");

	}

}
