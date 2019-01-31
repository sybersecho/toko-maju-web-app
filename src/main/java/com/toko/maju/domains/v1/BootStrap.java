package com.toko.maju.domains.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.toko.maju.services.CustomerService;
import com.toko.maju.services.ProjectService;
import com.toko.maju.services.SupplierService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BootStrap implements CommandLineRunner {

	private final CustomerService customerService;
	private final ProjectService projectService;
	@SuppressWarnings("unused")
	@Autowired
	private final SupplierService supplierService=null;

	public BootStrap(CustomerService customerService, ProjectService projectService) {
		this.customerService = customerService;
		this.projectService = projectService;
	}

	@Override
	public void run(String... args) throws Exception {
		loadCustomer();
		loadProjects();
		loadSupplier();

	}

	private void loadSupplier() {
		Supplier supplier = Supplier.builder()
				.id(1L)
				.address("address")
				.bankAccount("bank account")
				.bankName("bank name")
				.code("code")
				.name("Supplier name")
				.phoneNumber("12312313")
				.build();
		supplierService.save(supplier);
	}

	private void loadProjects() {
		Project project = Project.builder().id(1L).name("Project name").address("Project Address")
				.customer(customerService.getAll().iterator().next()).build();
		Project project2 = Project.builder().id(2L).name("Project name 2").address("Project Address 2")
				.customer(customerService.getAll().iterator().next()).build();
		log.debug("save project 1");
		System.out.println("save project 1");
		projectService.save(project);
		System.out.println("save project 2");
		log.debug("save project 2");
		projectService.save(project2);

		log.debug("project loaded");

	}

	private void loadCustomer() {
		Customer customer1 = Customer.builder().name("Customer 1").code("Code 1").address("address 1").build();
		Customer customer2 = Customer.builder().name("Customer 2").code("Code 2").address("address 2").build();

		customer1 = customerService.save(customer1);
		customer2 = customerService.save(customer2);

		log.debug("customer loaded");

	}

}
