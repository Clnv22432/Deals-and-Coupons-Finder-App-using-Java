package com.dealsandcouponsfinder.profilemanagement.exception;

public class ProfileRequestException extends RuntimeException{
	

	private static final long serialVersionUID = 1L;

	public ProfileRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProfileRequestException(String message) {
		super(message);
	}

}
