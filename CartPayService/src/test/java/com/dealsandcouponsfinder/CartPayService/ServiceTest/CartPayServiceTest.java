package com.dealsandcouponsfinder.CartPayService.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dealsandcouponsfinder.CartPayService.exception.CartPayRequestException;
import com.dealsandcouponsfinder.CartPayService.model.Cart;
import com.dealsandcouponsfinder.CartPayService.repository.CartRepository;
import com.dealsandcouponsfinder.CartPayService.service.CartService;


@SpringBootTest
public class CartPayServiceTest {
	
	
	@Autowired
	private CartService cartService;
	
	@MockBean
	private CartRepository cartRepository;
	
	@Test
	public void saveTest() {
		Cart cart = new Cart("1234567890","cvk403@gmail.com",5,"1234",20);
		when(cartRepository.save(cart)).thenReturn(cart);
		assertEquals(cart,cartService.save(cart));
	}
	
	@Test
	public void findByCartIdTest() throws CartPayRequestException {
		when (cartRepository.findById("2")).thenReturn(Optional.of(new Cart("2","cvk403@gmail.com",5,"1234",20)));
		Optional<Cart> cart = cartService.findByCartId("2");
		assertEquals("2", cart.get().getCartId());
		assertEquals("cvk403@gmail.com",cart.get().getUserId());
		assertEquals(5,cart.get().getQuantity());
		assertEquals("1234",cart.get().getCouponId());
		assertEquals(20,cart.get().getPrice());
	}
	
	@Test 
	 public void deleteByIdTest() throws CartPayRequestException {
		when (cartRepository.findById("2")).thenReturn(Optional.of(new Cart("2","cvk403@gmail.com",5,"1234",20)));
		doNothing().when(cartRepository).deleteById("2");
		assertEquals(cartService.deleteById("2"), "Id 2 deleted!");
	}	
	
	@Test
	public void findByUserIdTest() throws CartPayRequestException {
		when (cartRepository.findById("cvk403@gmail.com")).thenReturn(Optional.of(new Cart("2","cvk403@gmail.com",5,"1234",20)));
		Optional<Cart> cart = cartService.findByCartId("cvk403@gmail.com");
		assertEquals("2", cart.get().getCartId());
		assertEquals("cvk403@gmail.com",cart.get().getUserId());
		assertEquals(5,cart.get().getQuantity());
		assertEquals("1234",cart.get().getCouponId());
		assertEquals(20,cart.get().getPrice());
	}
}

