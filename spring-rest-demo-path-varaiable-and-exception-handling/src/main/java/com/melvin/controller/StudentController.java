package com.melvin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.melvin.entity.Student;
import com.melvin.exception.StudentErrorResponse;
import com.melvin.exception.StudentNotFoundException;

@RestController
public class StudentController {
	
	private List<Student> students;
	
	@PostConstruct
	public void generateStudentList() {
		students =new ArrayList<Student>();
		
		students.add(new Student(101,"melvin","benny"));
		students.add(new Student(102,"amal","jose"));
		students.add(new Student(103,"ARUN","RAJEEV"));
	}
	@GetMapping("/students")
	public List<Student> getStudents(){
		return students;
	}
	
	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable int id) {
		
		Student tempstudent=null;
		for(Student s:students) {
			if(s.getId()==id) {
				tempstudent=s;
				break;
			}
		}
		
		
		if(tempstudent==null) {
			throw new StudentNotFoundException("STUDENT ID NOT FOUND-"+id);
		}
		return tempstudent;
		
	}
	
	
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student)
	{
		students.add(student);
		return student;
		
	}
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception){
		StudentErrorResponse error=new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>(error,HttpStatus.NOT_FOUND);
		
	}

}
