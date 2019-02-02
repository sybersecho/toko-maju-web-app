package com.toko.maju.controllers.v1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.toko.maju.domains.v1.Product;
import com.toko.maju.services.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(ProductController.BASE_URL)
public class ProductController {
	public static final String BASE_URL = "/api/v1/products";

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		productService.getAll().forEach(products::add);
		return products;
	}

	@GetMapping({ "/{id}" })
	@ResponseStatus(HttpStatus.OK)
	public Product getById(@PathVariable Long id) {
		log.debug("calling getByID: " + id);
		return productService.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Product createNewProduct(@RequestBody Product newProduct) {
		log.debug("saving new Product");
		return productService.save(newProduct);
	}

	@PutMapping({ "/{id}" })
	@ResponseStatus(HttpStatus.OK)
	public Product updateProduct(@PathVariable Long id, @RequestBody Product updateProduct) {
		log.debug("update customer with ID: " + id);
		return productService.updateById(id, updateProduct);
	}

	@DeleteMapping({ "/{id}" })
	@ResponseStatus(HttpStatus.OK)
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteById(id);
	}
}
