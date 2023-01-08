package exception_handling.throws_keyword;

public class MainExceptionThrowsKeyword {
public static void main(String[] args) {
System.out.println("main begin");

	try {
		m1();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}

	System.out.println("main end");
}
static void m1() throws InterruptedException{
	System.out.println("m1");
   m2();
}
static void m2()throws InterruptedException {
	System.out.println("m2");
	int b=0;
	int a=6/b;
	System.out.println(a);
}
}
