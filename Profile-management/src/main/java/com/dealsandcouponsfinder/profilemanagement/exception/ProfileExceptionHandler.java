package com.dealsandcouponsfinder.profilemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProfileExceptionHandler {
	
	@ExceptionHandler(value= {ProfileRequestException.class})
	public ResponseEntity<Object> handleProfileRequestException(ProfileRequestException e){
		
		HttpStatus badRequest=HttpStatus.BAD_REQUEST;
		ProfileException apiException=new ProfileException(e.getMessage());
		return new ResponseEntity<Object>(apiException,badRequest);
	}

}
