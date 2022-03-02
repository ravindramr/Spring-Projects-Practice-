package com.app.dto;

import org.springframework.stereotype.Component;

@Component
public class TempOTP {

	private int otp;

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}
}
