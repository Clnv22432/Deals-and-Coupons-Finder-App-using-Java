package com.coupon.controller;

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

import com.coupon.model.Coupon;
import com.coupon.service.CouponService;



@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/coupon")
public class CouponController {
	
	@Autowired
	CouponService couponService;

	
	@PostMapping("/add")
	public Coupon addCoupon(@RequestBody Coupon deal) {
		Coupon coupon = couponService.save(deal);
		return coupon;
	}

	@GetMapping("/find/id/{couponId}")
	public Optional<Coupon> searchCouponByCouponId(@PathVariable("couponId") String couponId) {
		Optional<Coupon> coupon = couponService.findByCouponId(couponId);
		return coupon;
	}
	
	@GetMapping("/find/category/{category}")
	public List<Optional<Coupon>> searchCouponByCategory(@PathVariable("category") String category) {
		List<Optional<Coupon>> coupon = couponService.findByCategory(category);
		return coupon;
	}
	
	@GetMapping("/find/companyName/{companyName}")
	public List<Optional<Coupon>> searchCouponByCompanyName(@PathVariable("companyName") String companyName) {
		List<Optional<Coupon>> coupon = couponService.findByCompanyName(companyName);
		return coupon;
	}

	@DeleteMapping("/delete/id/{couponId}")
	public String deleteCouponBycouponId(@PathVariable("couponId") String couponId) {
		String result = couponService.deleteById(couponId);
		return result;
	}
	
	@DeleteMapping("/delete/category/{category}")
	public String deleteCouponByCategory(@PathVariable("category") String category) {
		String result = couponService.deleteByCategory(category);
		return result;
	}
	
	@DeleteMapping("/delete/companyName/{companyName}")
	public String deleteCouponByCompanyName(@PathVariable("companyName") String companyName) {
		String result = couponService.deleteByCompanyName(companyName);
		return result;
	}

	@GetMapping("/findall")
	public List<Coupon> findCoupon() {
		return (List<Coupon>) couponService.findAll();
	}

	@PutMapping("/update")
	public Coupon updateCoupon(@RequestBody Coupon deal) {
		Coupon coupon = couponService.save(deal);
		return coupon;
	}
}
