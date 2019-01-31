package com.toko.maju.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.toko.maju.domains.v1.Customer;
import com.toko.maju.repositories.CustomerRepo;
import com.toko.maju.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepo customerRepo;

	public CustomerServiceImpl(CustomerRepo customerRepo) {
		this.customerRepo = customerRepo;
	}

	@Override
	public Customer saveNewCustomer(Customer newCustomer) {
		return customerRepo.save(newCustomer);
	}

	@Override
	public Set<Customer> getAllCustomers() {
		Set<Customer> customers = new HashSet<Customer>();
		customerRepo.findAll().forEach(customers::add);
		return customers;
	}

	@Override
	public Customer findById(Long id) {
		return customerRepo.findById(id).orElse(null);
	}

	@Override
	public Customer saveCustomerById(Long id, Customer updateCustomer) {
		updateCustomer.setId(id);
		return customerRepo.save(updateCustomer);
	}

	@Override
	public void delete(Customer delete) {
		customerRepo.delete(delete);
	}

	@Override
	public void deleteById(Long id) {
		customerRepo.deleteById(id);
	}

}
