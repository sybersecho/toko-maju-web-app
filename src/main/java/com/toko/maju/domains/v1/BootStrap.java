package com.toko.maju.domains.v1;

import org.springframework.boot.CommandLineRunner;

import com.toko.maju.services.CustomerService;
import com.toko.maju.services.ProjectService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component
public class BootStrap implements CommandLineRunner {

	private final CustomerService customerService;
	private final ProjectService projectService;

	public BootStrap(CustomerService customerService, ProjectService projectService) {
		this.customerService = customerService;
		this.projectService = projectService;
	}

	@Override
	public void run(String... args) throws Exception {
		loadCustomer();
		loadProjects();

	}

	private void loadProjects() {
//		ProjectDTO project = ProjectDTO.builder().name("Project name").address("Project Address")
//				.customer(customerService.getAllCustomers().get(0)).build();
//		ProjectDTO project2 = ProjectDTO.builder().name("Project name 2").address("Project Address 2")
//				.customer(customerService.getAllCustomers().get(1)).build();
//		log.debug("save project 1");
//		System.out.println("save project 1");
//		projectService.saveNewProject(project);
//		System.out.println("save project 2");
//		log.debug("save project 2");
//		projectService.saveNewProject(project2);
//		
//		log.debug("project loaded");
		
	}

	private void loadCustomer() {
		Customer customer1 = Customer.builder().name("Customer 1").code("Code 1").address("address 1").build();
		Customer customer2 = Customer.builder().name("Customer 2").code("Code 2").address("address 2").build();

		customer1 = customerService.saveNewCustomer(customer1);
		customer2 = customerService.saveNewCustomer(customer2);

		log.debug("customer loaded");

	}

}
