package com.mainapp.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainapp.config.OtpTwilioConfig;
import com.twilio.rest.api.v2010.account.Message; // ✅ Correct import
import com.twilio.type.PhoneNumber;

@Service
public class OtpServiceImpl implements OtpService{

	@Autowired
	private OtpTwilioConfig otpTwilioConfig;

	// Store OTP against mobile number
	Map<String, String> otpMap = new HashMap<>();

	//Generate 6-digit OTP
	@Override
	public String generateOtp() {
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		return String.valueOf(otp);
	}

	//Send OTP
	@Override
	public String sendOtpToPhone(String mobileNumber) {

		String otp = generateOtp();

		PhoneNumber to = new PhoneNumber(mobileNumber);
		PhoneNumber from = new PhoneNumber(otpTwilioConfig.getPhoneNumber());
		String msgBody = "Your OTP is: " + otp;
		Message.creator(to, from, msgBody).create();
		otpMap.put(mobileNumber, otp);
		return "OTP sent successfully";
	}

	//Validate OTP
	@Override
	public String validatedOtp(String otp) {
		Set<String> keys = otpMap.keySet();
		String value = null;
		for (String key : keys)
			value = otpMap.get(key);
		if (value.equals(otp))
			return "otp validated successfully";
		else
			return "invalid otp";
	}
}