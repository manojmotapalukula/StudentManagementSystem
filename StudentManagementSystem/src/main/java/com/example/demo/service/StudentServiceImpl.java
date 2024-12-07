package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepository;

	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Student addStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public boolean deleteStudentById(long id) {
		boolean status = false;
				
		try{
			studentRepository.deleteById(id);
			status = true;
		}
		catch(Exception e) {
			status = false;
			e.printStackTrace();
			
		}
		
		return status;
	}

	@Override
	public Student getStudentById(long id) {
		
		return studentRepository.findById(id).get();
	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}

}
