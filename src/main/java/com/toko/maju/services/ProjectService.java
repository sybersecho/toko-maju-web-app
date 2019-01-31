package com.toko.maju.services;

import java.util.Set;

import com.toko.maju.domains.v1.Project;

public interface ProjectService {
	public Project saveNewProject(Project newProject);

	public Set<Project> getAllProjects();

	public Project findById(Long id);

	public Project saveProjectById(Long id, Project updated);

	public void delete(Project project);

	public void deleteById(Long id);
}
