package com.toko.maju.controllers.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toko.maju.domains.v1.Product;
import com.toko.maju.services.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(ProductController.BASE_URL)
public class ProductController extends AbstractController<Product, Long> {
	public static final String BASE_URL = "/api/v1/products";

	private final ProductService service = null;

	public ProductController(ProductService productService) {
		super(productService);
	}
}
