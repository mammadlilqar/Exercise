package ders007;

public class Employee {
int id;
String name;
String surname;
String phone;
String address;
int salary;
Employee(){
	
}
Employee(String n){
	System.out.println(n);
}
Employee(String a,String s){
	System.out.println(a);
	System.out.println(s);
	
}
Employee(String d,String p,int sl){
	System.out.println(d);
	System.out.println(p);
	System.out.println(sl);
	
}


}
