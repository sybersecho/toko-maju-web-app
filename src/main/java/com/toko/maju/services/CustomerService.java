package com.toko.maju.services;

import java.util.List;

import com.toko.maju.api.v1.model.CustomerDTO;

public interface CustomerService {
	public CustomerDTO saveNewCustomer(CustomerDTO newCustomer);

	public List<CustomerDTO> getAllCustomers();

	public CustomerDTO findById(Long id);
	
	public CustomerDTO saveCustomerByDTO(Long id, CustomerDTO updateCustomer);
}
