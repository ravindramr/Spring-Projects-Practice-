package com.app.dto;

import org.springframework.stereotype.Component;

@Component
public class SmsPojo {
	private String phoneNo;

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
