package com.toko.maju.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

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
	@Transactional
	public ProjectDTO saveNewProject(ProjectDTO newProject) {
		return saveAndReturnDTO(projectMap.toProject(newProject));
	}

	private ProjectDTO saveAndReturnDTO(Project project) {
		Project saved = projectRepo.save(project);
		ProjectDTO dto = projectMap.toProjectDTO(saved);
		return dto;
	}

	@Override
	public List<ProjectDTO> getAllProjects() {
		//customerRepo.findAll().stream().map(customerMapper::customerToCustomerDTO).collect(Collectors.toList());
		return projectRepo.findAll().stream().map(projectMap::toProjectDTO).collect(Collectors.toList());
	}

}
