package com.toko.maju.controllers.v1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.toko.maju.domains.v1.Customer;
import com.toko.maju.domains.v1.Project;
import com.toko.maju.services.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController extends AbstractController<Customer, Long> {
	public static final String BASE_URL = "/api/v1/customers";

	private final CustomerService customerService = null;

	public CustomerController(CustomerService customerService) {
		super(customerService);
	}

	@GetMapping({ "/{id}/projects" })
	@ResponseStatus(HttpStatus.OK)
	public List<Project> getCustomerProjects(@PathVariable Long id) {
		log.debug("load customer projects..");
		List<Project> projects = new ArrayList<Project>();
		customerService.customerProjects(id).forEach(projects::add);
		return projects;
	}

}
