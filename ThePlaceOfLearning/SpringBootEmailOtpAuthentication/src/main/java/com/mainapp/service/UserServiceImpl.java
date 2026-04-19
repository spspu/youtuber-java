package com.mainapp.service;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainapp.dto.LoginDto;
import com.mainapp.dto.UserDto;
import com.mainapp.entity.UserEntity;
import com.mainapp.repository.UserRepository;
import com.mainapp.util.EmailUtil;
import com.mainapp.util.OtpUtil;

import jakarta.mail.MessagingException;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private OtpUtil otpUtil;
	
	@Autowired
	private EmailUtil emailUtil;
	
	
	@Override
	public String register(UserDto userDto) throws MessagingException {
		String otp=otpUtil.generatedOtp();
		emailUtil.sendOtpEmail(userDto.getEmail(), otp);
		UserEntity user = new UserEntity();
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setOtp(otp);
		user.setOtpGeneratedTime(LocalDateTime.now());
		userRepo.save(user);
		return "user register successfull";
	}

	@Override
	public String verifyAccount(String email, String otp) {
		UserEntity userEntity = userRepo.findByEmail(email).orElseThrow(()->new RuntimeException("user not find with this email:"+email));
		if(userEntity.getOtp().equals(otp) && Duration.between(userEntity.getOtpGeneratedTime(), LocalDateTime.now()).getSeconds()<1*60){
			userEntity.setActive(true);
			userRepo.save(userEntity);
			return "otp verified you can login";
		}
		
		
		return "please regenerate & submit";
	}
	
	@Override
	public String regenerateOtp(String email) {
		UserEntity userEntity = userRepo.findByEmail(email).orElseThrow(()->new RuntimeException("user not find with this email:"+email));
		String otp=otpUtil.generatedOtp();
		try {
			emailUtil.sendOtpEmail(email, otp);
		} catch (Exception e) {
			throw new RuntimeException("unable to send otp please try again...");
		}
		userEntity.setOtp(otp);
		userEntity.setOtpGeneratedTime(LocalDateTime.now());
		userRepo.save(userEntity);
		return "email send ...., pls verify within 1 minute";
	}

	@Override
	public String login(LoginDto loginDto) {
		UserEntity userEntity=userRepo.findByEmail(loginDto.getEmail()).orElseThrow(()->new RuntimeException("user not found this email:"+loginDto.getEmail()));
		if(!loginDto.getPassword().equals(userEntity.getPassword())) {
			return "password is incorrect";
		}else if(! userEntity.isActive()) {
			return "your account is not verified";
		}
		
		return "login successfull";
	}

	@Override
	public String forgetPassword(String email) {
		userRepo.findByEmail(email).orElseThrow(()->new RuntimeException("user not found this email:"+email));
		try {
			emailUtil.sendSetPasswordEmail(email);
		} catch (Exception e) {
			throw new RuntimeException("unable to send password email please try again...");
		}
		return "please check your email to set new password to ur account";
	}

	@Override
	public String setPassword(String email, String newPassword) {
		UserEntity userEntity = userRepo.findByEmail(email).orElseThrow(()->new RuntimeException("user not found this email:"+email));
		userEntity.setPassword(newPassword);
		userRepo.save(userEntity);
		
		return "new password set successfully login with new password";
	}


	
	
	

}
