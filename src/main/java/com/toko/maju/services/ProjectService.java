package com.toko.maju.services;

import java.util.Set;

import com.toko.maju.domains.v1.Project;
import com.toko.maju.domains.v1.ProjectProduct;

public interface ProjectService extends IService<Project, Long> {

	public Set<ProjectProduct> getProjectProducts(Long id);

}
