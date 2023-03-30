package az.developia.springmvcilqar.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import az.developia.springmvcilqar.model.Student;
@Controller
public class StudentController {
@GetMapping(path = "/students")
public String showStudents(Model model){
	//String[] students= {"Nadir","Kamil","Sabir","lala"};
	//model.addAttribute("myStudents",students);
	
	ArrayList<Student> myStudents=new ArrayList<>();
	myStudents.add(new Student(2,"ilqar","Mammadli","ilqarmmdl88@gmail.com"));
	myStudents.add(new Student(5,"Nadir","Mammadov","Nadrmmv54@gmail.com"));
	myStudents.add(new Student(8,"Habil","Hasenov","Hhhl34@gmail.com"));
	model.addAttribute("myStudents",myStudents);
	return "students";
}
}
	
