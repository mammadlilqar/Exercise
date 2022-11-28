package ders007;

public class ClassAndObjectAndConstructors {
public static void main(String[] args) {
	//3.Main metodun daxilində 3 ədəd Computer obyekti yarat 
	//və hər obyektin yaradılmasında fərqli qurucu konstruktor istifadə et.
	Computer c1=new Computer();
	Computer c2=new Computer("Aspire");
	Computer c3=new Computer("Pavilion","gray");
	
	c1.id=1;
	c1.brand="Asus";
	c1.model="TUF";
	c1.color="black";
	
	c2.id=2;
	c2.brand="Acer";
	c2.model="Aspire";
	c2.color="black";
	
	c3.id=3;
	c3.brand="HP";
	c3.model="Pavilion";
	c3.color="grey";
	//4.Bu obyektlərin daxilində olan dəyişənlərin dəyərlərini ayrılıqda konsola çap et.
	System.out.println(c1.id+"."+c1.brand+"-"+c1.model+"-"+c1.color);
	System.out.println(c2.id+"."+c2.brand+"-"+c2.model+"-"+c2.color);
	System.out.println(c3.id+"."+c3.brand+"-"+c3.model+"-"+c3.color);
}
}
