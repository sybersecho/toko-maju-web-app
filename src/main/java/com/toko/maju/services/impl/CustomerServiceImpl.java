package com.toko.maju.services.impl;

import java.util.List;

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
//	public CustomerServiceImpl(CustomerRepo customerRepo, CustomerMapper customerMapper) {
//		this.customerRepo = customerRepo;
//		this.customerMapper = customerMapper;
//		toDTO = null;
//		fromDTO = null;
//	}

	@Override
	public Customer saveNewCustomer(Customer newCustomer) {
		return customerRepo.save(newCustomer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public Customer findById(Long id) {
		return customerRepo.getOne(id);
	}

	@Override
	public Customer saveCustomerById(Long id, Customer updateCustomer) {
		updateCustomer.setId(id);
		return customerRepo.save(updateCustomer);
	}

}
