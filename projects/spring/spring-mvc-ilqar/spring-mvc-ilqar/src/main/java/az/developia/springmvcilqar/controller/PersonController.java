package az.developia.springmvcilqar.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import az.developia.springmvcilqar.model.Person;

@Controller
@RequestMapping(path = "/persons")
public class PersonController {
@GetMapping
public String show(Model model) {
	
	ArrayList<Person> persons=new ArrayList<>();
	persons.add(new Person(8,"Ilqar",19,"Baku"));
	persons.add(new Person(3,"Nadir",28,"Ganja"));
	persons.add(new Person(7,"Sahil",24,"Sumqayit"));
	model.addAttribute("person",persons);
	return "persons";
}
}
