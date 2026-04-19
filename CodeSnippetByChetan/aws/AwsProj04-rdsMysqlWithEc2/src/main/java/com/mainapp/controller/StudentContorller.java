package com.mainapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mainapp.entity.StudentEntity;
import com.mainapp.repository.StudentRepository;

@RestController
public class StudentContorller {
	
	@Autowired
	private StudentRepository stdRepo;
	
	@PostMapping("/student")
	public StudentEntity save(@RequestBody StudentEntity product) {
		return stdRepo.save(product);
	}
	
	@GetMapping("/students")
	public List<StudentEntity> getAll(){
		return stdRepo.findAll();
	}
	

}
