package class_object;

public class MainClass {
	
	public static void main(String[] args) {
			Book b1=new Book();
			Book b2=new Book();
			
			b1.id=1;
			b1.name="Anna Karenina";
			b1.author="Lev Tolstoy";
			b1.pageCount=347;
			
			
			b2.id=2;
			b2.name="Səfillər";
			b2.author="Viktor Hüqo";
			b2.pageCount=287;
			
	System.out.println(b1.id);
	System.out.println(b1.name);
	System.out.println(b1.author);
	System.out.println(b1.pageCount);
	System.out.println(b1.description);


	System.out.println(b2.id);
	System.out.println(b2.name);
	System.out.println(b2.author);
	System.out.println(b2.pageCount);
	System.out.println(b2.description);	}
}


			



