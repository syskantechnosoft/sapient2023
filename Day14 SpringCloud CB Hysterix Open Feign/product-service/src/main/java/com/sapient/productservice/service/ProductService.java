package com.sapient.productservice.service;

import java.util.List;

import com.sapient.productservice.model.Product;

public interface ProductService {

	public List<Product> findAll();

	public Product findById(int id);

	public void save(Product product);

	public void update(int id, Product product);

	public void delete(int id);

}
