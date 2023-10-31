package com.sapient.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.productservice.model.Product;
import com.sapient.productservice.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).get();
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}

	@Override
	public void update(int id, Product product) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
