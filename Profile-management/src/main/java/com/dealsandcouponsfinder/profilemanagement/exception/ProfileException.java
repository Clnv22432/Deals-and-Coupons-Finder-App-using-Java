package com.dealsandcouponsfinder.profilemanagement.exception;

import org.springframework.http.HttpStatus;

public class ProfileException {
	
	private String errorMsg;
	
	private HttpStatus httpStatus;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public ProfileException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	
	}	
	
}
