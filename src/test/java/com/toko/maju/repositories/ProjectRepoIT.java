package com.toko.maju.repositories;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.toko.maju.domains.Customer;
import com.toko.maju.domains.Project;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProjectRepoIT {

	private final CustomerRepo customerRepo;
	private final ProjectRepo projectRepo;
	
	Customer testCustomer;
	Project testProject;

	@Autowired
	public ProjectRepoIT(CustomerRepo customerRepo, ProjectRepo projectRepo) {
		this.customerRepo = customerRepo;
		this.projectRepo = projectRepo;
	}

	@BeforeEach
	void setUp() throws Exception {
		testCustomer = new Customer();
		testCustomer.setAddress("address");
		testCustomer.setCode("code");
		testCustomer.setName("name");
		testCustomer.setPhoneNumber("phone Number");
		
		testCustomer = customerRepo.save(testCustomer);
	}

	@Test
	void testSaveProject() {
		saveProject();
		Long id = projectRepo.findAll().get(0).getId();
		
//		assertEquals(testProject.getId(), id);
		assertNotNull(id);
		
	}

	private void saveProject() {
		testProject = new Project();
		testCustomer.setAddress("Project Address");
		testProject.setName("Customer Name");
		testProject.setCustomer(testCustomer);
		
		testProject = projectRepo.save(testProject);
	}

}
