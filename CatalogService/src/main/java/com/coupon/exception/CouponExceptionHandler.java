package com.coupon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CouponExceptionHandler {

	@ExceptionHandler(value= {CouponRequestException.class})
	public ResponseEntity<Object> handleCatalogRequestException(CouponRequestException e){
		
		HttpStatus badRequest=HttpStatus.BAD_REQUEST;
	    CouponException apiException=new CouponException(e.getMessage());
		return new ResponseEntity<Object>(apiException,badRequest);
	}
}
