package com.toko.maju.services.impl;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.toko.maju.domains.v1.Project;
import com.toko.maju.repositories.ProjectRepo;
import com.toko.maju.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepo projectRepo;

	public ProjectServiceImpl(ProjectRepo projectRepo) {
		this.projectRepo = projectRepo;
	}

	@Override
	@Transactional
	public Project saveNewProject(Project newProject) {
		return projectRepo.save(newProject);
	}

	@Override
	public Set<Project> getAllProjects() {
		Set<Project> projects = new HashSet<Project>();
		projectRepo.findAll().forEach(projects::add);
		return projects;
	}

	@Override
	public Project findById(Long id) {
		return projectRepo.findById(id).orElse(null);
	}

	@Override
	public Project saveProjectById(Long id, Project updated) {
		updated.setId(id);
		return projectRepo.save(updated);
	}

	@Override
	public void delete(Project project) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

}
