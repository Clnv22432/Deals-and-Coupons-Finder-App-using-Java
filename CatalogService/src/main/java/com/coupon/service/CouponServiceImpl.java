package com.coupon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.coupon.exception.CouponRequestException;
import com.coupon.model.Coupon;
import com.coupon.repository.CouponRepository;
import com.coupon.service.CouponService;

@Service
public class CouponServiceImpl implements CouponService {
	@Autowired
	CouponRepository couponRepository;

	public Coupon save(Coupon deal) {
		Coupon coupon = couponRepository.save(deal);
		return coupon;
	}

	public List<Coupon> findAll() {
		return (List<Coupon>) couponRepository.findAll();
	}

	public Optional<Coupon> findByCouponId(String couponId) {
		Optional<Coupon> coupon = couponRepository.findById(couponId);
		if (coupon.isEmpty()) {
			throw new CouponRequestException("Id is not found");
		} else {
			return coupon;
		}
	}

	public List<Optional<Coupon>> findByCategory(String category) {
		List<Optional<Coupon>> coupon = couponRepository.findByCategory(category);
		if (coupon.isEmpty()) {
			throw new CouponRequestException("Category is not found");
		} else {
			return coupon;
		}
	}

	public List<Optional<Coupon>> findByCompanyName(String companyName) {
		List<Optional<Coupon>> coupon = couponRepository.findByCompanyName(companyName);
		if (coupon.isEmpty()) {
			throw new CouponRequestException("CompanyName is not found");
		} else {
			return coupon;
		}
	}

	public String deleteById(String id) {
		if (!findByCouponId(id).isEmpty()) {
			couponRepository.deleteById(id);
			return "Id " + id + " deleted!";
		} else {
			return "Id " + id + " is not found";
		}
	}

	public String deleteByCategory(String category) {
		List<Optional<Coupon>> coupons = findByCategory(category);
		if (coupons.size() > 0) {
			for (Optional<Coupon> coupon : coupons) {
				couponRepository.deleteById(coupon.get().getCouponId());
			}
			return "Category " + category + " deleted!";
		} else {
			return "Category " + category + " is not found";
		}
	}

	public String deleteByCompanyName(String companyName) {
		List<Optional<Coupon>> coupons = findByCompanyName(companyName);
		if (coupons.size() > 0) {
			for (Optional<Coupon> coupon : coupons) {
				couponRepository.deleteById(coupon.get().getCouponId());
			}
			return "Company name " + companyName + " deleted!";
		} else {
			return "Company name " + companyName + " is not found";
		}
	}
}
