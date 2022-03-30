package com.dealsandcouponsfinder.CartPayService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "CartDetails")
public class Cart {

	@Id
	private String cartId;
	@Field
	private String userId;
	@Field
	private int quantity;
	@Field
	private String couponId;
	@Field
	private double price;
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCouponId() {
		return couponId;
	}
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", quantity=" + quantity + ", couponId=" + couponId
				+ ", price=" + price + "]";
	}
	
	public Cart(String cartId, String userId, int quantity, String couponId, double price) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.quantity = quantity;
		this.couponId = couponId;
		this.price = price;
	}

	
	

}
