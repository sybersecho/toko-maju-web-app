package com.toko.maju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toko.maju.domains.v1.Supplier;

public interface SupplierRepo extends JpaRepository<Supplier, Long> {

}
