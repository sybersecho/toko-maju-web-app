package com.toko.maju.controllers.v1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
public class CustomerController {
	public static final String BASE_URL = "/api/v1/customers";

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Customer> getAllCustomers(Model model) {
		log.debug("calling getAllCustomers...");
		List<Customer> customers = new ArrayList<Customer>();
		customerService.getAll().forEach(customers::add);
		return customers;
	}

	@GetMapping({ "/{id}" })
	@ResponseStatus(HttpStatus.OK)
	public Customer getById(@PathVariable Long id) {
		log.debug("calling getByID: " + id);
		return customerService.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer createNewCustomer(@RequestBody Customer newCustomer) {
		log.debug("saving new customer");
		return customerService.save(newCustomer);
	}

	@PutMapping({ "/{id}" })
	@ResponseStatus(HttpStatus.OK)
	public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer updateCustomer) {
		log.debug("update customer with ID: " + id);
		return customerService.updateById(id, updateCustomer);
	}

	@DeleteMapping({ "/{id}" })
	@ResponseStatus(HttpStatus.OK)
	public void deleteCustomer(@PathVariable Long id) {
		customerService.deleteById(id);
	}

	@GetMapping({ "/{id}/projects" })
	@ResponseStatus(HttpStatus.OK)
	public List<Project> getCustomerProjects(@PathVariable Long id) {
		List<Project> projects = new ArrayList<Project>();
		customerService.customerProjects(id).forEach(projects::add);
		return projects;
	}

}
