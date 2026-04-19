package com.mainapp.service;

public interface OtpService {
	
	public String generateOtp();
	
	public String sendOtpToPhone(String mobileNumber);
	
	public String validatedOtp(String otp);

}
