package com.dealsandcouponsfinder.CartPayService.controller;

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

import com.dealsandcouponsfinder.CartPayService.model.Cart;
import com.dealsandcouponsfinder.CartPayService.service.CartService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService cartService;

	@PostMapping("/addCart")
	public Cart addCart(@RequestBody Cart cart) {
		Cart cart1 = cartService.save(cart);
		return cart1;
	}
	
	@GetMapping("/find/cartId/{cartId}")
	public Optional<Cart> searchCartByCartId(@PathVariable("cartId") String cartId) {
		Optional<Cart> cart = cartService.findByCartId(cartId);
		return cart;
	}
	
	@GetMapping("/find/userId/{userId}")
	public List<Optional<Cart>> searchCartByUserId(@PathVariable("userId") String userId) {
		List<Optional<Cart>> cart2 = cartService.findByUserId(userId);
		return cart2;
	}
	
	@GetMapping("/findall")
	public List<Cart> findCart() {
		return (List<Cart>) cartService.findAll();
	}
	
	@DeleteMapping("/deleteCart/{id}")
	public String deleteCartById(@PathVariable("id") String id) {
		String result = cartService.deleteById(id);
		return result;
	}
	
	@GetMapping("/totalPrice/{userId}")
	    public double getTotalPrice(@PathVariable("userId") String userId) {
	        double result=cartService.getTotalPrice(userId);
	    	return result;
	        }
	
	@DeleteMapping("/deleteAllCart/{userId}")
	public String deleteAllCart(@PathVariable("userId") String userId) {
		String result=cartService.deleteAllCart(userId);
		return result;
	}
	
	@PutMapping("/updateCart")
	public Cart updateCart(@RequestBody Cart cart) {
		Cart cart1 = cartService.save(cart);
		return cart1;
	}

}
