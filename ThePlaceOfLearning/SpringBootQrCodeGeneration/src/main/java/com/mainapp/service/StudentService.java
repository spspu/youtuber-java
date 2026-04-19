package com.mainapp.service;

import java.util.List;

import com.mainapp.entity.StudentEntity;

public interface StudentService {
	
	public List<StudentEntity> getStudents();
	
	public StudentEntity addStudent(StudentEntity studentEntity);
	
	public StudentEntity findById(Long id);
}
