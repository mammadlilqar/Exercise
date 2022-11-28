package ders007;

public class ClassAndObjectHome {
	public static void main(String[] args) {
		person p1=new person();
		person p2=new person();
		
		p1.id=1;
		p1.name="Nadir";
		p1.surname="Mammadov";
		p1.age=19;
		p1.phone="0772345678";
		
		p2.id=2;
		p2.name="Malik";
		p2.surname="Hasanov";
		p2.age=22;
		p2.phone="0552449285";
		
		System.out.println(p1.id);
		System.out.println(p1.name);
		System.out.println(p1.surname);
		System.out.println(p1.age);
		System.out.println(p1.phone);
		
		System.out.println(p2.id);
		System.out.println(p2.name);
		System.out.println(p2.surname);
		System.out.println(p2.age);
		System.out.println(p2.phone);
		
	}

}
