package com.toko.maju.services;

import java.util.List;

import com.toko.maju.domains.v1.Project;

public interface ProjectService {
	public Project saveNewProject(Project newProject);
	public List<Project> getAllProjects();
}
