package com.toko.maju.controllers.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toko.maju.domains.v1.Project;
import com.toko.maju.services.ProjectService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = { ProjectController.BASE_URL })
public class ProjectController extends AbstractController<Project, Long> {
	public static final String BASE_URL = "/api/v1/projects";

	private final ProjectService service = null;

	public ProjectController(ProjectService service) {
		super(service);
	}

}
