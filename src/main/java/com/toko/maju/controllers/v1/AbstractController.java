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
import org.springframework.web.bind.annotation.ResponseStatus;

import com.toko.maju.services.IService;

public abstract class AbstractController<T, ID> {

	private IService<T, ID> service;

	public static String BASE_URL = "";

	public AbstractController(IService<T, ID> service) {
		this.service = service;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<T> getAllT() {
		List<T> tList = new ArrayList<T>();
		service.getAll().forEach(tList::add);
		return tList;
	}

	@GetMapping({ "/{id}" })
	@ResponseStatus(HttpStatus.OK)
	public T getTById(@PathVariable ID id) {
//		log.debug("calling getByID: " + id);
		return service.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public T createNewCustomer(@RequestBody T newT) {
//		log.debug("saving new customer");
		return service.save(newT);
	}

	@DeleteMapping({ "/{id}" })
	@ResponseStatus(HttpStatus.OK)
	public void deleteT(@PathVariable ID id) {
		service.deleteById(id);
	}

	@PutMapping({ "/{id}" })
	@ResponseStatus(HttpStatus.OK)
	public T updateT(@PathVariable ID id, @RequestBody T updateT) {
//		log.debug("update customer with ID: " + id);
		return service.updateById(id, updateT);
	}
}
