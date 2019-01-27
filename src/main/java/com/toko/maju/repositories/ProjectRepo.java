package com.toko.maju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toko.maju.domains.Project;

public interface ProjectRepo extends JpaRepository<Project, Long> {

}
