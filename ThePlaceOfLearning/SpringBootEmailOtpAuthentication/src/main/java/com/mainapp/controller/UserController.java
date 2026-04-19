package com.mainapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mainapp.dto.LoginDto;
import com.mainapp.dto.UserDto;
import com.mainapp.service.UserService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody UserDto userDto) throws MessagingException{
		
		return new ResponseEntity<String>(userService.register(userDto),HttpStatus.OK);
	}
	
	@PutMapping("/verify-account")
	public ResponseEntity<String> verifyAccount(@RequestParam String email,@RequestParam String otp){
		
		return new ResponseEntity<String>(userService.verifyAccount(email, otp),HttpStatus.OK);
	}
	
	
	@PutMapping("/regenerate-otp")
	public ResponseEntity<String> regenerateOtp(@RequestParam String email){
		return new ResponseEntity<>(userService.regenerateOtp(email),HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
		return new ResponseEntity<>(userService.login(loginDto),HttpStatus.OK);
	}
	
	@PutMapping("/forget-password")
	public ResponseEntity<String> forgetPassword(@RequestParam String email){
		return new ResponseEntity<String>(userService.forgetPassword(email),HttpStatus.OK);
	}
	
	@PutMapping("/set-password")
	public ResponseEntity<String> setPassword(@RequestParam String email,@RequestParam String newPassword){
		return new ResponseEntity<String>(userService.setPassword(email, newPassword),HttpStatus.OK);
	}
	
	
	
}
