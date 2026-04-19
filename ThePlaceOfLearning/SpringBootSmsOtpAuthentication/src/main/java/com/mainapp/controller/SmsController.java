package com.mainapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mainapp.service.OtpService;

@RestController
public class SmsController{
	
	@Autowired
	public OtpService otpService;
	
	//send otp
	@PostMapping("/sendOtp")
	public String sendData(@RequestParam String mobileNumber) {
		return otpService.sendOtpToPhone(mobileNumber);
	}
	
	//validate otp
	@PostMapping("/verifyOtp")
	public String verifyOtp(@RequestParam String otp) {
		return otpService.validatedOtp(otp);
	}

}
