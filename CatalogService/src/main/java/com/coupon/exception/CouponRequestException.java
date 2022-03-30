package com.coupon.exception;

public class CouponRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CouponRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public CouponRequestException(String message) {
		super(message);
	}

}
