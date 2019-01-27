package com.toko.maju.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.toko.maju.api.v1.model.ProjectDTO;
import com.toko.maju.domains.Project;

@Mapper
public interface ProjectMapper {
	ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

	ProjectDTO toProjectDTO(Project project);

	Project toProject(ProjectDTO projectDTO);
}
