package com.toko.maju.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.toko.maju.domains.v1.Product;
import com.toko.maju.repositories.ProductRepo;
import com.toko.maju.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepo productRepo;

	public ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	@Override
	public Product save(Product entity) {
		return productRepo.save(entity);
	}

	@Override
	public Product findById(Long id) {
		return productRepo.findById(id).orElse(null);
	}

	@Override
	public Product updateById(Long id, Product entity) {
		entity.setId(id);
		return productRepo.save(entity);
	}

	@Override
	public void delete(Product entity) {
		productRepo.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		productRepo.deleteById(id);
	}

	@Override
	public Set<Product> getAll() {
		Set<Product> products = new HashSet<Product>();
		productRepo.findAll().forEach(products::add);
		return products;
	}

}
