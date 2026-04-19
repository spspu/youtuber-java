package in.sp.main;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.sp.main.entities.Student;
import in.sp.main.services.StudentService;
import in.sp.main.services.StudentServiceImpl;

@SpringBootApplication
public class SpringBootWithDataJpa1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootWithDataJpa1Application.class, args);
		StudentService stdService = context.getBean(StudentServiceImpl.class);
		
		
//		-------Insert Operation--------
//		Student std = new Student();
//		std.setName("amit");
//		std.setRollno(58);
//		std.setMarks(96.2f);
//		
//		boolean status = stdService.addStudentDetails(std);
//		if(status)
//		{
//			System.out.println("Student inserted successfully");
//		}else {
//			System.out.println("Student not inserted due to some error");
//		}
		
		
		
		
//		--------Select Operation 1---------
//		List<Student>stdList = stdService.getAllStdDetails();
//		for(Student std: stdList)
//		{
//			System.out.println("Id: "+std.getId());
//			System.out.println("Name: "+std.getName());
//			System.out.println("Rollno: "+std.getRollno());
//			System.out.println("Marks: "+std.getMarks());
//			
//			System.out.println("---------------------");
//		}
		
		
		
//		---------Select Operation 2----------
//		Student std = stdService.getStdDetails(3L);
//		if(std != null) {
//			System.out.println("Id: "+std.getId());
//			System.out.println("Name: "+std.getName());
//			System.out.println("Rollno: "+std.getRollno());
//			System.out.println("Marks: "+std.getMarks());
//			
//		}else {
//			System.out.println("Student not found");
//		}
		
		
//		----------Update Operation---------
//		boolean status= stdService.updateStdDetails(1L,91.7f);
//		if(status) {
//			System.out.println("Student details update successfully");
//		}else {
//			System.out.println("Student details not upadated due to some error");
//		}
		
		
//		---------Delete Operation------------
		boolean status = stdService.deleteStdDetails(2L);
		if(status) {
			System.out.println("Student details deleted successfully");
		}else {
			System.out.println("Student details not deleted");
		}
	}

}
