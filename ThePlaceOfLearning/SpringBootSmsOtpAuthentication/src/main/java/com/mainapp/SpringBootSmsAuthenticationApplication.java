package com.mainapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mainapp.config.OtpTwilioConfig;
import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SpringBootSmsAuthenticationApplication {
	
	@Autowired
	private OtpTwilioConfig otpTwilioConfig;
	
	@PostConstruct
	public void setup() {
		Twilio.init(otpTwilioConfig.getAccountSid(),otpTwilioConfig.getAuthToken());
	}
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSmsAuthenticationApplication.class, args);
	}

}
