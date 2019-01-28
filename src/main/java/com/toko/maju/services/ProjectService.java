package com.toko.maju.services;

import java.util.List;

import com.toko.maju.api.v1.model.ProjectDTO;

public interface ProjectService {
	public ProjectDTO saveNewProject(ProjectDTO newProject);
	public List<ProjectDTO> getAllProjects();
}
