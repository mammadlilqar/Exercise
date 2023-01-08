package exception_handling.practise;

public class MainExceptions {
public static void main(String[] args) {
	System.out.println("main begin");
	int a=5;
	int b=0;
	try {
		int c=a/b;
		System.out.println(c);
	}catch(ArithmeticException exc) {
		System.out.println(exc.getMessage());
	}
System.out.println("main end");
}
}
