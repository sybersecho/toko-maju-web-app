package com.toko.maju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toko.maju.domains.v1.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
