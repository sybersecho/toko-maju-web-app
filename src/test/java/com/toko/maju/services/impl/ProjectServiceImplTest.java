package com.toko.maju.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.toko.maju.domains.v1.Project;
import com.toko.maju.repositories.ProjectRepo;
import com.toko.maju.services.ProjectService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ProjectServiceImplTest {

	@Mock
	ProjectRepo projectRepo;

	@Mock
	ProjectService projectService;

	Project sampleProject;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		sampleProject = Project.builder().name("name").build();
	}

	@Test
	void testSave() {
		log.debug("testing save project...");
		when(projectService.save(any())).thenReturn(sampleProject);

		Project dto = projectService.save(any());
		assertEquals(dto.getId(), sampleProject.getId());

		verify(projectService, times(1)).save(any());
//		verify(projectRepo, timeout(1)).save(any());

	}

}
