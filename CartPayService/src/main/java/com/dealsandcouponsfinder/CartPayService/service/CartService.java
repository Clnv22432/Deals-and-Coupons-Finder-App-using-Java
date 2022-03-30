package com.dealsandcouponsfinder.CartPayService.service;

import java.util.List;
import java.util.Optional;

import com.dealsandcouponsfinder.CartPayService.model.Cart;

public interface CartService {

	Cart save(Cart cart);

	List<Cart> findAll();

	String deleteById(String id);

	double getTotalPrice(String userId);

	String deleteAllCart(String userId);

	Optional<Cart> findByCartId(String cartId);

	List<Optional<Cart>> findByUserId(String userId);


}
