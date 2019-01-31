package com.toko.maju.services;

import java.util.Set;

import com.toko.maju.domains.v1.Customer;

public interface CustomerService {
	public Customer saveNewCustomer(Customer newCustomer);

	public Set<Customer> getAllCustomers();

	public Customer findById(Long id);

	public Customer saveCustomerById(Long id, Customer updateCustomer);

	public void delete(Customer delete);

	public void deleteById(Long id);
}
