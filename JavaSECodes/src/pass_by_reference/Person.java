package pass_by_reference;

public class Person {
String name;
String surname;
int experienceYear;
int salary;
String phone;

void printInfo(String name,String surname,int experienceYear,int salary,String phone){
	System.out.println("name:"+name);
	System.out.println("surname:"+surname);
	System.out.println("experienceYear:"+experienceYear);
	System.out.println("phone:"+phone);
	System.out.println("salary:"+salary);
	
	
}

Person(String name,String surname,int experienceYear,String phone){
	this.name=name;
	this.surname=surname;
	this.experienceYear=experienceYear;
	this.phone=phone;
}
}
