package com.toko.maju.services.impl;

import org.springframework.stereotype.Service;

import com.toko.maju.api.v1.mapper.ProjectMapper;
import com.toko.maju.api.v1.model.ProjectDTO;
import com.toko.maju.domains.Project;
import com.toko.maju.repositories.ProjectRepo;
import com.toko.maju.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepo projectRepo;
	private final ProjectMapper projectMap;

	public ProjectServiceImpl(ProjectRepo projectRepo, ProjectMapper projectMap) {
		this.projectRepo = projectRepo;
		this.projectMap = projectMap;
	}

	@Override
	public ProjectDTO save(ProjectDTO newProject) {
		Project toBeSave = projectMap.toProject(newProject);
		toBeSave = projectRepo.save(toBeSave);
		return projectMap.toProjectDTO(toBeSave);
	}

}
