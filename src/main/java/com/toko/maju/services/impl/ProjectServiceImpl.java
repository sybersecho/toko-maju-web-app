package com.toko.maju.services.impl;

import java.util.HashSet;
import java.util.Set;

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
	public Project save(Project entity) {
		return projectRepo.save(entity);
	}

	@Override
	public Project findById(Long id) {
		return projectRepo.findById(id).orElse(null);
	}

	@Override
	public Project updateById(Long id, Project updated) {
		updated.setId(id);
		return projectRepo.save(updated);
	}

	@Override
	public void delete(Project entity) {
		projectRepo.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		projectRepo.deleteById(id);
	}

	@Override
	public Set<Project> getAll() {
		Set<Project> projects = new HashSet<Project>();
		projectRepo.findAll().forEach(projects::add);
		return projects;
	}

}
