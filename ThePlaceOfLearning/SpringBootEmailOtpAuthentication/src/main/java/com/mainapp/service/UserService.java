package com.mainapp.service;

import com.mainapp.dto.LoginDto;
import com.mainapp.dto.UserDto;

import jakarta.mail.MessagingException;

public interface UserService {
	
	public String register(UserDto userDto) throws MessagingException;
	
	public String verifyAccount(String email, String otp);
	
	public String regenerateOtp(String email);
	
	public String login(LoginDto loginDto);
	
	public String forgetPassword(String email);
	
	public String setPassword(String email,String newPassword);
	
	

}
