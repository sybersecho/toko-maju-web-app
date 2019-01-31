package com.toko.maju.controllers.v1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.toko.maju.domains.v1.Supplier;
import com.toko.maju.services.SupplierService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = { SupplierController.BASE_URL })
public class SupplierController {
	public static final String BASE_URL = "/api/v1/suppliers";

	private final SupplierService service;

	public SupplierController(SupplierService service) {
		this.service = service;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Supplier> getAllSupplier() {
		List<Supplier> suppliers = new ArrayList<Supplier>();
		service.getAll().forEach(suppliers::add);
		return suppliers;
	}

	@GetMapping({ "/{id}" })
	@ResponseStatus(HttpStatus.OK)
	public Supplier getSupplierById(@PathVariable Long id) {
		log.debug("find Supplier wiht id: {}", id);
		return service.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Supplier saveNewSupplier(@RequestBody Supplier newSupplier) {
		log.debug("save new Supplier");
		return service.save(newSupplier);
	}

	@PutMapping({ "/{id}" })
	@ResponseStatus(HttpStatus.OK)
	public Supplier updateSupplier(@PathVariable Long id, @RequestBody Supplier updateSupplier) {
		log.debug("update project wiht id: {}", id);
		return service.updateById(id, updateSupplier);
	}

	@DeleteMapping({ "/{id}" })
	@ResponseStatus(HttpStatus.OK)
	public void deleteSupplier(@PathVariable Long id) {
		log.debug("delete Supplier with id: {}", id);
		service.deleteById(id);
	}
}
