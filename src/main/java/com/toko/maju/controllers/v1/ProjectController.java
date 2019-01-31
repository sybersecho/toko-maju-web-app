package com.toko.maju.controllers.v1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.toko.maju.domains.v1.Project;
import com.toko.maju.services.ProjectService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = { ProjectController.BASE_URL })
public class ProjectController {
	public static final String BASE_URL = "/api/v1/projects";

	private final ProjectService service;

	public ProjectController(ProjectService service) {
		this.service = service;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<Project>();
		service.getAll().forEach(projects::add);
		return projects;
	}

	@GetMapping({ "/{id}" })
	@ResponseStatus(HttpStatus.OK)
	public Project getProjectById(Long id) {
		log.debug("find project wiht id: {}", id);
		return service.findById(id);
	}

	@PostMapping(value = "/")
	@ResponseStatus(HttpStatus.CREATED)
	public Project saveProject(@RequestBody Project newProject) {
		log.debug("save new project");
		return service.save(newProject);
	}

	@PutMapping({ "/{id}" })
	@ResponseStatus(HttpStatus.OK)
	public Project updateProject(@PathVariable Long id, @RequestBody Project updateProject) {
		log.debug("update project wiht id: {}", id);
		return service.updateById(id, updateProject);
	}

	@DeleteMapping({ "/{id}" })
	@ResponseStatus(HttpStatus.OK)
	public void deleteProject(@PathVariable Long id) {
		log.debug("delete project with id: {}", id);
		service.deleteById(id);
	}

}
