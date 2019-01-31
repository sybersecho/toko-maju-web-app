package com.toko.maju.services;

import java.util.Set;

import com.toko.maju.domains.v1.Customer;
import com.toko.maju.domains.v1.Project;

public interface CustomerService extends IService<Customer, Long> {
	public Set<Project> customerProjects(Long id);
}
