package com.toko.maju.services.impl;

import java.util.List;

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
	public List<Project> getAllProjects() {
		return projectRepo.findAll();
	}

}
