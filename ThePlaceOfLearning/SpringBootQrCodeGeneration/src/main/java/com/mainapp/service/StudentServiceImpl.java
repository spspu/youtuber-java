package com.mainapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainapp.entity.StudentEntity;
import com.mainapp.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<StudentEntity> getStudents() {
		return studentRepo.findAll();
	}

	@Override
	public StudentEntity addStudent(StudentEntity studentEntity) {
		return studentRepo.save(studentEntity);
	}

	@Override
	public StudentEntity findById(Long id) {
		return studentRepo.findById(id).orElseThrow(()->new RuntimeException("student not found"));
	}
	
	

}
