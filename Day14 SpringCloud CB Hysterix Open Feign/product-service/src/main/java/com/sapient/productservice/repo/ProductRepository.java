package com.sapient.productservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.productservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	public List<Product> findByPrice(double price);

	public List<Product> findByNameAndPrice(String name, double price);
}
