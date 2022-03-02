package com.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StoreOTP;
import com.app.dto.TempOTP;

@RestController
@Controller
@RequestMapping(value = "/verifyOtp", method = RequestMethod.POST)
public class VerifyOTPController {

	// @PostMapping("/otp")

	//@RequestMapping(value = "/otp", method = RequestMethod.POST)
	
	public boolean verifyOTP(TempOTP sms) {
		System.out.println("inside OPT verification class line 22");
		if (sms.getOtp() == StoreOTP.getOtp())
		{
			System.out.println("otp is correct");
			return true;
		}
		else
		{
			System.out.println("otp is incorrect");
		
			return false;
		}
	}

}

