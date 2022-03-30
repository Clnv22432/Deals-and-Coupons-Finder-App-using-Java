package com.microservice.ProductsService.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Products {

	@Id
	private String id;
	
	private String name;
	private double price;
	private double rating;
	private String imageUrl;
	private String category;
	
	public Products() {
		super();
	}

	public Products(String id, String name, double price, double rating, String imageUrl, String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.rating = rating;
		this.imageUrl = imageUrl;
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", price=" + price + ", rating=" + rating + ", imageUrl="
				+ imageUrl + ", category=" + category + "]";
	}

	
}