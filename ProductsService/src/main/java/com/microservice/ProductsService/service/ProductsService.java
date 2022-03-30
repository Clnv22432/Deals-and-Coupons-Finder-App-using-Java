package com.microservice.ProductsService.service;

import java.util.List;
import java.util.Optional;

import com.microservice.ProductsService.models.Products;

public interface ProductsService {
	List<Products> getAllProducts();
	Products addProduct(Products product);
	Object getProductById(String id);
	Products updateProduct(Products product);
	void deleteProductById(String id);
	List<Optional<Products>> findByCategory(String category);

}
