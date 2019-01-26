package com.toko.maju.services;

import com.toko.maju.api.v1.model.CustomerDTO;

public interface CustomerService {
	public CustomerDTO save(CustomerDTO newCustomer);
}
