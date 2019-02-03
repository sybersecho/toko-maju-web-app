package com.toko.maju.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.toko.maju.domains.v1.Customer;
import com.toko.maju.domains.v1.Product;
import com.toko.maju.domains.v1.Project;
import com.toko.maju.domains.v1.ProjectProduct;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProjectServiceIT {

	private final ProjectService projectService;
	private final CustomerService customerService;
	private final ProductService productService;
	Customer customer;

	@Autowired
	public ProjectServiceIT(ProjectService projectService, CustomerService customerService,
			ProductService productService) {
		this.projectService = projectService;
		this.customerService = customerService;
		this.productService = productService;
	}

	@BeforeEach
//	@Transactional
	void setUp() throws Exception {
		customer = Customer.builder().id(1L).address("Address").build();
		customer = customerService.save(customer);
		saveProject();
		saveProducts();
	}

	private void saveProducts() {
		Product p1 = Product.builder().id(1L).name("Product 1").barcode("000000000").build();
		p1 = productService.save(p1);

		Product p2 = Product.builder().id(2L).name("Product 1").barcode("000000000").build();
		p2 = productService.save(p2);
	}

	@Test
	void testSaveProject() {
//		saveProject();
		Project p = projectService.findById(1L);
		assertNotNull(p.getId());
	}

	@Test
	void testFindOne() {
		Project found = projectService.getAll().iterator().next();
		assertNotNull(found);
	}

	@Test
	@Transactional
	void testSaveProjectProducts() {
		System.out.println("@@@@@@@@@@@@test save project product");
		Customer first = customerService.findById(1L);
		Project newProject = Project.builder()
				.name("Project 1")
				.customer(first)
				.build();
		System.out.println("@@@@@@@@@@@@@find a product");
		Product product = productService.findById(1L);
		Product product2 = productService.findById(2L);
		
		ProjectProduct pp = new ProjectProduct(newProject, product, BigDecimal.TEN);
		newProject.getProducts().add(pp);
		ProjectProduct pp1 = new ProjectProduct(newProject, product2, BigDecimal.TEN);
		newProject.getProducts().add(pp1);
		
		System.out.println("@@@@@@@@@@@@@save new project");
		projectService.save(newProject);
	}

	private Project saveProject() {
		Project project = Project.builder().address("address").name("name")
				.customer(customerService.getAll().iterator().next()).build();

		project = projectService.save(project);
		return project;
	}

}
