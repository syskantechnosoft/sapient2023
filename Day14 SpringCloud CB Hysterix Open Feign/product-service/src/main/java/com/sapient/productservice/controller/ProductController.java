package com.sapient.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.productservice.model.Product;
import com.sapient.productservice.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/products")
	public List<Product> findAll() {
		return productService.findAll();
	}

	@GetMapping("/products/{id}")
	public Product findById(@PathVariable int id) {
		return productService.findById(id);
	}

	@PostMapping("/products")
	public void save(@RequestBody Product product) {
		productService.save(product);
	}

	@PutMapping("/products/{id}")
	public void update(@PathVariable int id, @RequestBody Product product) {
		productService.update(id, product);
	}

	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable int id) {
		productService.delete(id);
	}

}
