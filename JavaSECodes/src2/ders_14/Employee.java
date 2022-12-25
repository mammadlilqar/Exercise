package ders_14;

public class Employee extends Person{
int salary;
String department;
String username;
String password;

void printInfo() {
	super.printInfo();
	System.out.println("salary:"+salary);
	System.out.println("department:"+ department);
	System.out.println("username:"+username);
	System.out.println("password:"+password);


}

}
