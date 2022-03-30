package com.microservice.ProductsService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.microservice.ProductsService.models.Products;
import com.microservice.ProductsService.service.ProductsServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	ProductsServiceImpl productsServiceImpl;
	
	@GetMapping("/")
	public List<Products> getAllProducts() {
		return productsServiceImpl.getAllProducts();
	}
	
	@GetMapping("/product/{id}")
	public Object getProductById(@PathVariable String id) {
		return productsServiceImpl.getProductById(id);
	}
	
	@GetMapping("/find/category/{category}")
	public List<Optional<Products>> searchProductsByCategory(@PathVariable("category") String category) {
		List<Optional<Products>> coupon = productsServiceImpl.findByCategory(category);
		return coupon;
	}
	
	
	
	@PostMapping("/product")
	public Products addProduct(@RequestBody Products product) {
		return productsServiceImpl.addProduct(product);
	}
	
	@PutMapping("/product")
	public Products updateProduct(@RequestBody Products product) {
		return productsServiceImpl.updateProduct(product);
	}
	
	@DeleteMapping("/product/{id}")
	public void deleteProductById(@PathVariable String id) {
		productsServiceImpl.deleteProductById(id);
	}
	
}