package com.toko.maju.controllers.v1;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.toko.maju.services.SupplierService;

public class SupplierControllerTest {
	@Mock
	SupplierService supplierService;

	@InjectMocks
	SupplierController controller;

	MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

//	@Test
	void testGetAllSupplier() {
		fail("Not yet implemented"); // TODO
	}

//	@Test
	void testGetSupplierById() {
		fail("Not yet implemented"); // TODO
	}

//	@Test
	void testSaveSupplier() {
		fail("Not yet implemented"); // TODO
	}

//	@Test
	void testUpdateSupplier() {
		fail("Not yet implemented"); // TODO
	}

//	@Test
	void testDeleteProject() {
		fail("Not yet implemented"); // TODO
	}
}
