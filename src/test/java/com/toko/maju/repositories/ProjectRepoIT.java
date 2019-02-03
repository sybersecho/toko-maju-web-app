package com.toko.maju.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
class ProjectRepoIT {

	private final CustomerRepo customerRepo;
	private final ProjectRepo projectRepo;
//	@Autowired
//	private final ProductService productService = null;
	
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
		Project returned = projectRepo.findById(1L).orElse(null);
		
		assertNotNull(returned);
//		assertEquals(testProject.getId(), returned.getId());
		
		assertNotNull(returned.getCustomer());
		
	}

	private void saveProject() {
		testProject = new Project();
		testCustomer.setAddress("Project Address");
		testProject.setName("Customer Name");
		testProject.setCustomer(testCustomer);
		
		testProject = projectRepo.save(testProject);
		
		
	}

}
