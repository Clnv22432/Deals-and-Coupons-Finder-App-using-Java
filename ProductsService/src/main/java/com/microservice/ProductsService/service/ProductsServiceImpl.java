package com.microservice.ProductsService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.ProductsService.models.Products;
import com.microservice.ProductsService.repository.ProductsRepository;

@Service
public class ProductsServiceImpl {

	@Autowired
	ProductsRepository productsRepository;
	
	public List<Products> getAllProducts() {
		return productsRepository.findAll();
	}

	public Products addProduct(Products product) {
		return productsRepository.insert(product);
	}

	public Object getProductById(String id) {
		return productsRepository.findById(id);
	}

	public Products updateProduct(Products product) {
		return productsRepository.save(product);
	}

	public void deleteProductById(String id) {
		productsRepository.deleteById(id);
	}


	public List<Optional<Products>> findByCategory(String category) {
		
		return productsRepository.findByCategory(category);
	}

	
	

}
