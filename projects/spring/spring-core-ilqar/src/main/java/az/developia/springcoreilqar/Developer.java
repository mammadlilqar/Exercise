package az.developia.springcoreilqar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Developer {
private String name;
private int salary;
private String department;
@Autowired(required = false)
@Qualifier(value ="myComputer" )
private Computer computer;

public Developer() {
	name="Ilqar";
	salary=500;
	department="IT";
  
}

public Computer getComputer() {
	return computer;
}
public void setComputer(Computer computer) {
	this.computer = computer;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}


}
