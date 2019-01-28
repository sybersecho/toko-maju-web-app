package com.toko.maju.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.toko.maju.api.v1.model.CustomerDTO;
import com.toko.maju.api.v1.model.CustomerListDTO;
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
	public CustomerListDTO getAllCustomers(Model model) {
		log.debug("calling getAllCustomers...");

		return new CustomerListDTO(customerService.getAllCustomers());
	}

	@GetMapping({"/{id}"})
	@ResponseStatus(HttpStatus.OK)
	public CustomerDTO getById(@PathVariable Long id) {
		log.debug("calling getByID: " + id);
		return customerService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerDTO createNewCustomer(@RequestBody CustomerDTO newCustomer) {
		log.debug("saving new customer");
		return customerService.save(newCustomer);
	}

}
