package ders8metodlar;

public class Methods {
public static void main(String[] args) {
	Methods m1=new Methods();
	m1.printName(3,"Kamil");
	System.out.println("------");
	m1.printName(2,"Hesen");
	System.out.println("------");
	m1.printName(1,"Cavid");
	
} 
void  printName(int count,String name) {
	for(int i=1;i<=count;i++) {
		System.out.println("name:"+name);
	}
	
}
}
