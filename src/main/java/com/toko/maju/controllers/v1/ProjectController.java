package com.toko.maju.controllers.v1;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.toko.maju.domains.v1.Project;
import com.toko.maju.domains.v1.ProjectProduct;
import com.toko.maju.services.ProjectService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = { ProjectController.BASE_URL })
public class ProjectController extends AbstractController<Project, Long> {
	public static final String BASE_URL = "/api/v1/projects";

	@Autowired
	private ProjectService service;

	public ProjectController(ProjectService service) {
		super(service);
	}

	@GetMapping({ "/{id}/products" })
	@ResponseStatus(HttpStatus.OK)
	public Project getProjectProduct(@PathVariable Long id) {
		log.info("get product of project by id: {}", id);
//		List<ProjectProduct> projectProducts = new ArrayList<ProjectProduct>();
//		service.getProjectProducts(id).forEach(projectProducts::add);

		return service.findById(id);
	}

	@PostMapping({ "/{id}/products" })
	@ResponseStatus(HttpStatus.OK)
	public Project saveProductProject(@PathVariable Long id, @RequestBody Project project) {
		return service.updateById(id, project);
	}

	@Override
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Project createNewT(@RequestBody Project project) {
		log.info("Create new project...");
		Set<ProjectProduct> products = project.getProducts();

		if (!products.isEmpty()) {
			log.info("clear project product...");
//			project.getProducts().clear();
			Set<ProjectProduct> newProduct = new HashSet<ProjectProduct>();
			for (ProjectProduct projectProduct : products) {
				log.info("add project...");
				projectProduct.setProject(project);
				newProduct.add(projectProduct);
			}
			project.setProducts(newProduct);
		}
		
		log.info("is empty: " + project.getProducts().isEmpty());
		return service.save(project);
	}

}
