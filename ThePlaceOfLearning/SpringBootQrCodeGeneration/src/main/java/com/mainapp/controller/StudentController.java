package com.mainapp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;
import com.mainapp.entity.StudentEntity;
import com.mainapp.service.StudentService;
import com.mainapp.util.QrCodeGenerated;

@RestController
@RequestMapping("/std")
public class StudentController {
	
	@Autowired
	private StudentService stdService;
	
	@GetMapping
	public ResponseEntity<List<StudentEntity>> getStudents() throws WriterException, IOException{
		List<StudentEntity> students = stdService.getStudents();
		if(students.size() != 0) {
			for(StudentEntity student:students) {
				QrCodeGenerated.generatedQrCode(student);
			}
		}
		return ResponseEntity.ok(stdService.getStudents());
	}
	
	@PostMapping
	public StudentEntity addStudent(@RequestBody StudentEntity stdEntity) {
		return stdService.addStudent(stdEntity);
	}
	
	@GetMapping("/{id}")
	public StudentEntity findById(@PathVariable("id") long id) {
		return stdService.findById(id);
	}

}
