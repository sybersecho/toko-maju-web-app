package com.toko.maju.services.impl;

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
	public CustomerDTO save(CustomerDTO newCustomer) {
		Customer toSave = customerMapper.customerDTOToCustomer(newCustomer);
		toSave = customerRepo.save(toSave);
		CustomerDTO dto = customerMapper.customerToCustomerDTO(toSave);
		return dto;
	}

}
