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

import com.toko.maju.response.v1.APIResponse;
import com.toko.maju.response.v1.ResponseUtil;
import com.toko.maju.services.IService;

public abstract class AbstractController<T, ID> {

	private IService<T, ID> service;

	public static String BASE_URL = "";

//	@Autowired
//	protected ResponseUtil responseUtil;

	public AbstractController(IService<T, ID> service) {
		this.service = service;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public APIResponse<Object> getAllT() {
		List<T> tList = new ArrayList<T>();
		service.getAll().forEach(tList::add);
		
		return ResponseUtil.successResponse(tList);
	}

	@GetMapping({ "/{id}" })
	@ResponseStatus(HttpStatus.OK)
	public APIResponse<Object> getTById(@PathVariable ID id) {
//		log.debug("calling getByID: " + id);
		return ResponseUtil.successResponse(service.findById(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public APIResponse<Object> createNewT(@RequestBody T newT) {
//		log.debug("saving new customer");
		return ResponseUtil.successResponse(service.save(newT));
	}

	@DeleteMapping({ "/{id}" })
	@ResponseStatus(HttpStatus.OK)
	public APIResponse<Object>  deleteT(@PathVariable ID id) {
		service.deleteById(id);
		return ResponseUtil.successResponse(id);
	}

	@PutMapping({ "/{id}" })
	@ResponseStatus(HttpStatus.OK)
	public APIResponse<Object> updateT(@PathVariable ID id, @RequestBody T updateT) {
//		log.debug("update customer with ID: " + id);
		return ResponseUtil.successResponse(service.updateById(id, updateT));
	}
}
