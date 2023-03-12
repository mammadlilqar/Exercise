package az.developia.springcoreilqar;

import org.springframework.stereotype.Component;

@Component
public class Person {
	private int id;
	private String name;
	private String surname;
	private int salary;
	private int age;

	public Person() {
		id =1;
		name = "Ilqar";
		surname = "Mammadli";
		age = 19;
		salary = 1200;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
