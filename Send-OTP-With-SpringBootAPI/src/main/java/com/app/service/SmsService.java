package com.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.app.dto.SmsPojo;
import com.app.dto.StoreOTP;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Component
public class SmsService {
	//private final String ACCOUNT_SID = "ACd56b92782e1a94c70da6257e7801f581";
	private final String ACCOUNT_SID = "AC8aa9f0d70fd8ade61015c1a5dc004fb4";

	//private final String AUTH_TOKEN = "48ee4e93340014178a1c4f13be121bbb";
	private final String AUTH_TOKEN = "cab2115c6915883a998265bd2a97e620";

	//private final String FROM_NUMBER = "+18124456034";
	private final String FROM_NUMBER = "+18608463428";

	public void send(SmsPojo sms) throws ParseException {

		System.out.println(" ");

		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		int min = 100000;
		int max = 999999;
		int number = (int) (Math.random() * (max - min + 1) + min);

		String msg = "Your OTP - " + number + " please verify this OTP in your Application";

		Message message = Message.creator(new PhoneNumber(sms.getPhoneNo()), new PhoneNumber(FROM_NUMBER), msg)
				.create();
		StoreOTP.setOtp(number);

		System.out.println(message);
		System.out.println(message);

	}

	public void receive(MultiValueMap<String, String> smscallback) {

	}

}