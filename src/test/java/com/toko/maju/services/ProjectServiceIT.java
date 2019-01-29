package com.toko.maju.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.toko.maju.domains.v1.Customer;
import com.toko.maju.domains.v1.Project;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProjectServiceIT {

	private final ProjectService projectService;
	private final CustomerService customerService;
	Customer customer;

	@Autowired
	public ProjectServiceIT(ProjectService projectService, CustomerService customerService) {
		this.projectService = projectService;
		this.customerService = customerService;
	}

	@BeforeEach
	@Transactional
	void setUp() throws Exception {
		customer = Customer.builder().address("Address").build();
		customer = customerService.saveNewCustomer(customer);
		saveProject();
	}

//	@Test
	void testSaveProject() {
//		ProjectDTO dto = saveProject();
//
//		assertNotNull(dto.getId());
//		assertEquals(cDto.getId(), dto.getCustomer().getId());
	}

	@Test
	void testFindOne() {
//		saveProject();

		Project founDto = projectService.getAllProjects().get(0);

		assertNotNull(founDto);
	}

	private Project saveProject() {
		Project dto = Project.builder().address("address").name("name").customer(customerService.getAllCustomers().get(0)).build();

		dto = projectService.saveNewProject(dto);
		return dto;
	}

}
