package com.toko.maju.services;

import java.util.List;

import com.toko.maju.domains.v1.Customer;

public interface CustomerService {
	public Customer saveNewCustomer(Customer newCustomer);

	public List<Customer> getAllCustomers();

	public Customer findById(Long id);
	
	public Customer saveCustomerById(Long id, Customer updateCustomer);
}
