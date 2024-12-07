package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {
	private StudentService  studentService;
	
	

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}



	//get all students
	@GetMapping("/students")
	public String getStudents(Model model) {
		model.addAttribute("students",studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/add")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student",student);
		return "students-add";
		
	}
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute Student student) {
		studentService.addStudent(student);
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
		model.addAttribute("student",studentService.getStudentById(id));
		return "student-edit";
		
	}
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute Student student, Model model ) {
		Student existing = studentService.getStudentById(id);
		existing.setId(id);
		existing.setFirstName(student.getFirstName());
		existing.setLastName(student.getLastName());
		existing.setEmail(student.getEmail());
		studentService.updateStudent(existing);
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/{id}")
	public String delStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
		
	}
	
	
	

}
