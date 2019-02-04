package com.toko.maju.controllers.v1;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toko.maju.domains.v1.Project;
import com.toko.maju.response.v1.ResponseUtil;
import com.toko.maju.services.ProjectService;

class ProjectControllerTest {

	@Mock
	ProjectService service;
	
	@Mock
	ResponseUtil responseutil;

	@InjectMocks
	ProjectController controller;

	MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	void testGetAllProjects() throws Exception {
//		Project project1 = Project.builder().id(1L).build();
//		Project project2 = Project.builder().id(1L).build();

//		List<Project> projects = Arrays.asList(project1, project2);
//		when(cu)

		mockMvc.perform(get(ProjectController.BASE_URL).
				contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void testGetProjectById() throws Exception {
		Project project1 = Project.builder().id(1L).name("Project 1").build();
		
		when(service.findById(1L)).thenReturn(project1);

		mockMvc.perform(get(ProjectController.BASE_URL + "/1")
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
			//.andExpect(jsonPath("$.name", equalTo("Project 1")));

	}

//	@Test
	void testSaveProject() throws Exception {
		Project project1 = Project.builder().id(1L).build();
		Project returned = Project.builder().id(1L).build();
		
		when(service.save(project1)).thenReturn(returned);
		
		mockMvc.perform(post(ProjectController.BASE_URL + "/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(project1)))
			.andExpect(status().isCreated());
	}

//	@Test
	void testUpdateProject() throws Exception {
		Project project1 = Project.builder().id(1L).build();
		Project returned = Project.builder().id(1L).build();
		
		when(service.updateById(anyLong(), any())).thenReturn(returned);
		
		mockMvc.perform(post(ProjectController.BASE_URL + "/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(project1)))
			.andExpect(status().isCreated());
	}

//	@Test TODO
	void testDeleteProject() throws Exception {
		mockMvc.perform(delete(ProjectController.BASE_URL + "/1")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

	private static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
