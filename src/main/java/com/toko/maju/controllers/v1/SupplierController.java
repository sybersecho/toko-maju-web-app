package com.toko.maju.controllers.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toko.maju.domains.v1.Supplier;
import com.toko.maju.services.SupplierService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = { SupplierController.BASE_URL })
public class SupplierController extends AbstractController<Supplier, Long> {
	public static final String BASE_URL = "/api/v1/suppliers";

	private final SupplierService service = null;

	public SupplierController(SupplierService service) {
		super(service);
	}
}
