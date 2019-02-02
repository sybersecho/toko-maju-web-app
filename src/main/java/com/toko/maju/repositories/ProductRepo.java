package com.toko.maju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toko.maju.domains.v1.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
