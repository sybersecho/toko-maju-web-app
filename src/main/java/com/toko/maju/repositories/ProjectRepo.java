package com.toko.maju.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toko.maju.domains.v1.Project;
import com.toko.maju.domains.v1.ProjectProduct;

public interface ProjectRepo extends JpaRepository<Project, Long> {
	public List<ProjectProduct> getProjectProductById(Long id);
}
