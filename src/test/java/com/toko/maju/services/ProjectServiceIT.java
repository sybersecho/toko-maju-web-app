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
		customer = Customer.builder().id(1L).address("Address").build();
		customer = customerService.save(customer);
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

		Project found = projectService.getAll().iterator().next();

		assertNotNull(found);
	}

	private Project saveProject() {
		Project project = Project.builder().address("address").name("name")
				.customer(customerService.getAll().iterator().next()).build();

		project = projectService.save(project);
		return project;
	}

}
