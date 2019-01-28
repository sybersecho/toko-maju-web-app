package com.toko.maju.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.toko.maju.api.v1.mapper.CustomerMapper;
import com.toko.maju.api.v1.model.CustomerDTO;
import com.toko.maju.domains.Customer;
import com.toko.maju.repositories.CustomerRepo;
import com.toko.maju.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepo customerRepo;
	private final CustomerMapper customerMapper;

	public CustomerServiceImpl(CustomerRepo customerRepo, CustomerMapper customerMapper) {
		this.customerRepo = customerRepo;
		this.customerMapper = customerMapper;
	}

	@Override
	public CustomerDTO saveNewCustomer(CustomerDTO newCustomer) {
		return saveAndReturnDTO(customerMapper.customerDTOToCustomer(newCustomer));
	}

	private CustomerDTO saveAndReturnDTO(Customer customer) {
		Customer saved = customerRepo.save(customer);
		CustomerDTO dto = customerMapper.customerToCustomerDTO(saved);
		return dto;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		return customerRepo.findAll().stream().map(customerMapper::customerToCustomerDTO).collect(Collectors.toList());
	}

	@Override
	public CustomerDTO findById(Long id) {
		return customerMapper.customerToCustomerDTO(customerRepo.getOne(id));
	}

	@Override
	public CustomerDTO saveCustomerByDTO(Long id, CustomerDTO updateCustomer) {
		Customer updated = customerMapper.customerDTOToCustomer(updateCustomer);
		updated.setId(id);
		return saveAndReturnDTO(updated);
	}

}
