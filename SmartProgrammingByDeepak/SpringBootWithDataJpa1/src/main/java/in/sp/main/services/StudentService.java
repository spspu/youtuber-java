package in.sp.main.services;

import java.util.List;

import in.sp.main.entities.Student;

public interface StudentService {

	boolean addStudentDetails(Student std);
	
	public List<Student> getAllStdDetails();
	public Student getStdDetails(long id);
	public boolean updateStdDetails(long id, float marks);
	public boolean deleteStdDetails(long id);
	
	
}
