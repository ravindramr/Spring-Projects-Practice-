
package com.app.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.app.dto.SmsPojo;
import com.app.dto.StoreOTP;
import com.app.dto.TempOTP;
import com.app.service.SmsService;

@Controller
@RequestMapping(value = "/mobileNo", method = RequestMethod.POST)
public class SMSController {
	@Autowired
	SmsService service;
	@Autowired
	private SimpMessagingTemplate webSocket;

//	@Autowired
	// private VerifyOTPController verifyOTP;

	private final String TOPIC_DESTINATION = "/lesson/sms";// You can send SMS in verified Number

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		System.out.println("inside controller class form method line 31");

		return "login";
	}

	// @PostMapping(value= "/getmobile", method = RequestMethod.POST)
	@RequestMapping(value = "/getmobile", method = RequestMethod.POST)
	public String smsSubmit(@ModelAttribute("sms") @RequestBody SmsPojo sms, Model model) {// SmsPojo we imported from
																							// dao class
		try {
			System.out.println("inside controller class line 41");

			model.addAttribute("phoneNo", sms.getPhoneNo());

			System.out.println("hello your mobile number is " + sms.getPhoneNo());

			service.send(sms);

			System.out.println("hello this is printing after otp generated.");
		} catch (Exception e) {
			System.out.println("Something Problem" + HttpStatus.INTERNAL_SERVER_ERROR);
			System.out.println(e.getMessage());
			// return new ResponseEntity<String>("Something Problem",
			// HttpStatus.INTERNAL_SERVER_ERROR);

		}
		webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": SMS has been sent!: " + sms.getPhoneNo());
		// return new ResponseEntity<String>("OTP Send Successfully", HttpStatus.OK);
		return "login";
	}

	private String getTimeStamp() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
	}

	@RequestMapping(value = "/otp", method = RequestMethod.POST)

	public String verifyOTP(@ModelAttribute("totp") @RequestBody TempOTP totp, Model model) {

		System.out.println("inside OTP verification class line 70");

		model.addAttribute("otp", totp.getOtp());

		System.out.println("your OTP is " + totp.getOtp());
		
		  VerifyOTPController verifyOTP = new VerifyOTPController(); 
		  
		 if( verifyOTP.verifyOTP(totp)==true)
		 
		     return "bookingseat";
		 else
			 return "login";
			 
	}
}
