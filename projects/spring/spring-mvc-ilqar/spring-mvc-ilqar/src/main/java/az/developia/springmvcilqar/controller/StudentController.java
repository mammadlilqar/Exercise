package az.developia.springmvcilqar.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import az.developia.springmvcilqar.model.Student;
import az.developia.springmvcilqar.repository.StudentRepository;

@Controller

public class StudentController {
 @Autowired
 StudentRepository repository;
	@GetMapping(path = "/students")
	public String showStudents(Model model,
			@RequestParam(name = "query", required = false, defaultValue = "") String q) {

		model.addAttribute("myStudents", repository.findAll(q));
		model.addAttribute("searchText", q);
		return "students";
	} 
	
	@GetMapping(path = "/open-save-student-page")
	public String openSaveStudent(Model model) {
		Student s=new Student();
		s.setBirthday(Date.valueOf(LocalDate.now()));
		model.addAttribute("student", s);
		return "save-student";
	}
	@PostMapping(path = "/save-student")
	public String saveStudent(@ModelAttribute(name = "student") Student s) {
	repository.save(s);
		
	
		return "redirect:/students";
	}
	@GetMapping(path = "/students/{id}")
	public String openSaveStudent(@PathVariable Integer id) {
	
		return  "redirect:/students";
	}	
}
