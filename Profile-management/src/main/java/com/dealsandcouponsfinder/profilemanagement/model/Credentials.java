package com.dealsandcouponsfinder.profilemanagement.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Credentials")
public class Credentials {
	@NotEmpty
	@Id
	private String emailId;
	@NotEmpty
	@Field
	private String password;
	

	public Credentials() {
		super();
	}

	public Credentials(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Credentials [emailId=" + emailId + ", password=" + password + "]";
	}
	

	

	
	

	

}
