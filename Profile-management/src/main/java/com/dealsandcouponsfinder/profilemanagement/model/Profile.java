package com.dealsandcouponsfinder.profilemanagement.model;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

@Document(collection = "Profile")
public class Profile {
	@Email
	@NotBlank(message = "Email is mandatory")
	@NotEmpty(message = "Email is mandatory")
	@Id
	private String emailId;
	@NotBlank(message = "Name is mandatory")
	@Field
	private String fullName;
	@NotBlank(message = "Mobile number is mandatory")
	@Field
	private String mobileNo;
	@NotBlank(message = "Password is mandatory")
	@Field
	private String password;
	
	
	

	public Profile() {
		super();
	}




	public Profile(String emailId, String fullName, String mobileNo, String password) {
		super();
		this.emailId = emailId;
		this.fullName = fullName;
		this.mobileNo = mobileNo;
		this.password = password;
	}




	public String getEmailId() {
		return emailId;
	}




	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}




	public String getFullName() {
		return fullName;
	}




	public void setFullName(String fullName) {
		this.fullName = fullName;
	}




	public String getMobileNo() {
		return mobileNo;
	}




	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	@Override
	public String toString() {
		return "Profile [emailId=" + emailId + ", fullName=" + fullName + ", mobileNo=" + mobileNo + ", password="
				+ password + "]";
	}
	

	
}
