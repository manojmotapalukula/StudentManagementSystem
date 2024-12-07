package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
	public Student addStudent(Student student);
	public Student updateStudent(Student student);
	public boolean deleteStudentById(long id);
	public Student getStudentById(long id);
	public List<Student> getAllStudents();

}
