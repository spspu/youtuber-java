package com.mainapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Configuration
@ConfigurationProperties(prefix="twilio")
@Data
@NoArgsConstructor
@ToString
public class OtpTwilioConfig {
	
	private String accountSid;
	private String authToken;
	private String phoneNumber;
	
	

}
