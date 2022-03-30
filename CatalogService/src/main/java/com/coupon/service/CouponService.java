package com.coupon.service;

import java.util.List;
import java.util.Optional;

import com.coupon.model.Coupon;

public interface CouponService {

	Coupon save(Coupon deal);

	List<Optional<Coupon>> findByCategory(String category);

	List<Optional<Coupon>> findByCompanyName(String companyName);

	String deleteByCategory(String category);

	List<Coupon> findAll();

	String deleteByCompanyName(String companyName);

	String deleteById(String couponId);

	Optional<Coupon> findByCouponId(String couponId);

}
