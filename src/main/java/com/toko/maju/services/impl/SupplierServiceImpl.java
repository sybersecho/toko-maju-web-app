package com.toko.maju.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.toko.maju.domains.v1.Supplier;
import com.toko.maju.repositories.SupplierRepo;
import com.toko.maju.services.SupplierService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SupplierServiceImpl implements SupplierService {

	private final SupplierRepo repo;

	public SupplierServiceImpl(SupplierRepo repo) {
		this.repo = repo;
	}

	@Override
	public Supplier save(Supplier entity) {
		log.debug("Saving new Supplier...");
		return repo.save(entity);
	}

	@Override
	public Supplier findById(Long id) {
		log.debug("find supplier with ID: " + id);
		return repo.findById(id).orElse(null);
	}

	@Override
	public Supplier updateById(Long id, Supplier entity) {
		log.debug("update supplier with ID: " + id);
		entity.setId(id);
		return repo.save(entity);
	}

	@Override
	public void delete(Supplier entity) {
		log.debug("delete supplier with ID: " + entity.getId());
		repo.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		log.debug("delete supplier with ID: " + id);
		repo.deleteById(id);

	}

	@Override
	public Set<Supplier> getAll() {
		log.debug("Get all suppliers");
		Set<Supplier> suppliers = new HashSet<Supplier>();
		repo.findAll().forEach(suppliers::add);
		return suppliers;
	}

}
