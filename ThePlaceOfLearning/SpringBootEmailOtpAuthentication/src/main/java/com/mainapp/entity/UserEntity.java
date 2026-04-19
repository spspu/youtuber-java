package com.mainapp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="email")
@Entity
@Data
@NoArgsConstructor
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String password;
	private boolean active;
	private String otp;
	private LocalDateTime otpGeneratedTime;

}
