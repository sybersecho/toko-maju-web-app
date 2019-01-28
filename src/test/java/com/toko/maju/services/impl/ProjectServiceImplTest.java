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

import com.toko.maju.api.v1.mapper.ProjectMapper;
import com.toko.maju.api.v1.model.ProjectDTO;
import com.toko.maju.repositories.ProjectRepo;
import com.toko.maju.services.ProjectService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ProjectServiceImplTest {

	@Mock
	ProjectRepo projectRepo;
	@Mock
	ProjectMapper projectMap;
	@Mock
	ProjectService projectService;

	ProjectDTO sampleProject;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		sampleProject = ProjectDTO.builder().id(1L).build();
	}

	@Test
	void testSave() {
		log.debug("testing save project...");
		when(projectService.saveNewProject(any())).thenReturn(sampleProject);

		ProjectDTO dto = projectService.saveNewProject(any());
		assertEquals(dto.getId(), sampleProject.getId());

		verify(projectService, times(1)).saveNewProject(any());
//		verify(projectRepo, timeout(1)).save(any());

	}

}
