package com.toko.maju.services;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.toko.maju.api.v1.model.CustomerDTO;
import com.toko.maju.api.v1.model.ProjectDTO;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProjectServiceIT {

	private final ProjectService projectService;
	private final CustomerService customerService;
	CustomerDTO cDto;

	@Autowired
	public ProjectServiceIT(ProjectService projectService, CustomerService customerService) {
		this.projectService = projectService;
		this.customerService = customerService;
	}

	@BeforeEach
	@Transactional
	void setUp() throws Exception {
		cDto = CustomerDTO.builder().address("Address").build();
		cDto = customerService.saveNewCustomer(cDto);
	}

	@Test
	void testSaveProject() {
		ProjectDTO dto = saveProject();

		assertNotNull(dto.getId());
		assertEquals(cDto.getId(), dto.getCustomer().getId());
	}

//	@Test
	void testFindOne() {
		saveProject();

		ProjectDTO founDto = projectService.getAllProjects().get(0);

		assertNotNull(founDto);
	}

	private ProjectDTO saveProject() {
		ProjectDTO dto = ProjectDTO.builder().address("address").name("name").customer(cDto).build();

		dto = projectService.saveNewProject(dto);
		return dto;
	}

}
